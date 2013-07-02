package com.mofamulu.tieba.map;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.model.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ FreeNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FreeNearbyActivity freeNearbyActivity) {
        this.a = freeNearbyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        av m;
        boolean z;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        ImageView imageView13;
        ImageView imageView14;
        imageView = this.a.B;
        if (view != imageView) {
            imageView2 = this.a.C;
            if (view != imageView2) {
                imageView3 = this.a.D;
                if (view != imageView3) {
                    imageView4 = this.a.v;
                    if (view != imageView4) {
                        imageView5 = this.a.E;
                        if (view != imageView5) {
                            imageView6 = this.a.F;
                            if (view == imageView6) {
                                this.a.n();
                                Activity activity = this.a.g.getActivity("nearby_post");
                                FreeJumpByMapActivity.a(this.a, 811, (!(activity instanceof FreeNearbyPostActivity) || (m = ((FreeNearbyPostActivity) activity).m()) == null) ? 0 : m.b());
                                return;
                            }
                            return;
                        }
                        this.a.n();
                        FreeJumpByHandActivity.a(this.a, 811);
                        return;
                    }
                    this.a.n();
                    this.a.c();
                    return;
                }
                this.a.n();
                this.a.b(0);
                return;
            }
            this.a.n();
            this.a.b(1);
            return;
        }
        z = this.a.H;
        if (!z) {
            imageView7 = this.a.C;
            imageView7.setVisibility(8);
            imageView8 = this.a.D;
            imageView8.setVisibility(8);
            imageView9 = this.a.E;
            imageView9.setVisibility(8);
            imageView10 = this.a.F;
            imageView10.setVisibility(8);
            this.a.H = true;
            return;
        }
        imageView11 = this.a.D;
        imageView11.setVisibility(0);
        imageView12 = this.a.C;
        imageView12.setVisibility(0);
        imageView13 = this.a.E;
        imageView13.setVisibility(0);
        imageView14 = this.a.F;
        imageView14.setVisibility(0);
        this.a.H = false;
    }
}
