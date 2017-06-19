package org.launchcode.models.data;

import org.launchcode.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Christy on 6/18/2017. We do not touch the DB directly. This class "does it" for us as an interface.
 */
@Repository
@Transactional
public interface CheeseDao extends CrudRepository<Cheese, Integer> {
}
