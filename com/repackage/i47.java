package com.repackage;

import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.repackage.ft4;
/* loaded from: classes6.dex */
public interface i47 extends ft4.g {
    void loadMore();

    void netCallback(j47 j47Var);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
