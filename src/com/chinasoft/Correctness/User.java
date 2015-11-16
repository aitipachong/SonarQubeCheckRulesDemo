package com.chinasoft.Correctness;

import com.chinasoft.FieldsAreNonnullByDefault;

@FieldsAreNonnullByDefault
public class User 
{
    private String name;

    /**
     * 为一个已经声明为不能为null值的属性赋值为null
     * Correctness - Store of null value into field annotated NonNull
     */
    public User() {
        name = null;
        // "Store of null value into field User.name annotated Nonnull"
    }
}