package com.repackage;

import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.repackage.du4;
/* loaded from: classes6.dex */
public interface p67 extends du4.g {
    void loadMore();

    void netCallback(q67 q67Var);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
