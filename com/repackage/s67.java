package com.repackage;

import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.repackage.cu4;
/* loaded from: classes7.dex */
public interface s67 extends cu4.g {
    void loadMore();

    void netCallback(t67 t67Var);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
