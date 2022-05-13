package com.repackage;

import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.repackage.pu4;
/* loaded from: classes6.dex */
public interface g67 extends pu4.g {
    void loadMore();

    void netCallback(h67 h67Var);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
