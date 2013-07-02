package com.mofamulu.tieba.map;

import com.baidu.tieba.model.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.a.d {
    final /* synthetic */ g a;
    private final /* synthetic */ aw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, aw awVar) {
        this.a = gVar;
        this.b = awVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        FreeJumpByMapActivity freeJumpByMapActivity;
        if (bVar != null) {
            if (this.b.a() == 100) {
                this.b.a(0);
                freeJumpByMapActivity = this.a.d;
                freeJumpByMapActivity.a(this.b);
            } else if (this.b.a() == 101) {
                this.b.a(0);
            }
        }
    }
}
