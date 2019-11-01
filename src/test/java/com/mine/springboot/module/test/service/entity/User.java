package com.mine.springboot.module.test.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

/**
 * description:
 *
 * @author longcheng.guo   <longcheng.guo@ucarinc.com>
 * @version v1.0
 * @date 2019/10/30
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String username;
    private String password;

}
