package io.memento.domain.services;

import io.memento.domain.model.Account;

import java.util.List;

/**
 * Project: Memento
 * User:    Jérémy Buget
 * Email:   jbuget@agile-spirit.fr
 * Date:    20/08/2014
 */
public interface AccountService {

    List<Account> list();

    Account findAccountByUserId(String userId);

    Account save(Account account);

    Account update(Account account);

    void delete(Long id);
}
