package d.b.i0.d1.i.a;

import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import d.b.h0.r.f0.f;
/* loaded from: classes3.dex */
public interface a extends f.g {
    void loadMore();

    void netCallback(d.b.i0.d1.i.a.b.a aVar);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
