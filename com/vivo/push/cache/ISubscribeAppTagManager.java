package com.vivo.push.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public interface ISubscribeAppTagManager {
    boolean delTags(Set<String> set);

    void delTagsSuccess(Set<String> set);

    ArrayList<String> getRetrySubscribeAppInfo();

    ArrayList<String> getRetryUnsubscribeAppInfo();

    List<String> getSubscribeTags();

    boolean setTags(Set<String> set);

    void setTagsSuccess(Set<String> set);
}
