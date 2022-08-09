package com.repackage;

import java.util.List;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes7.dex */
public interface rs7 {
    int getErroCode();

    String getErrorText();

    List<Post> getPostList();

    ExcellentPbThreadInfo getThreadInfo();

    UserInfo getUserInfo();

    List<User> getUserList();

    boolean isEmpty();
}
