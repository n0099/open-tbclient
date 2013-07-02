package com.mofamulu.tieba.map;

import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ FreeNearbyForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FreeNearbyForumActivity freeNearbyForumActivity) {
        this.a = freeNearbyForumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.like /* 2131165548 */:
                this.a.a((String) view.getTag(R.id.tag_nearby_forum_name), (String) view.getTag(R.id.tag_nearby_forum_id));
                return;
            case R.id.nearby_forum_node_layout /* 2131165862 */:
                String str = (String) view.getTag();
                if (com.baidu.tieba.util.y.b(str)) {
                    FrsActivity.a(this.a, str, "tb_suishoufa");
                    return;
                }
                return;
            default:
                return;
        }
    }
}
