package com.yy.hiidostatis.message;

import com.yy.hiidostatis.api.StatisContent;
import java.util.List;
/* loaded from: classes7.dex */
public interface MessageStore {
    int notSave(List<StatisContent> list);

    int save(List<StatisContent> list);
}
