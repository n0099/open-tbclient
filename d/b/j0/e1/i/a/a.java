package d.b.j0.e1.i.a;

import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import d.b.i0.r.f0.f;
/* loaded from: classes4.dex */
public interface a extends f.g {
    void loadMore();

    void netCallback(d.b.j0.e1.i.a.b.a aVar);

    void netResidueCallback(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData);

    void onServerError(ErrorData errorData);

    void refresh();
}
