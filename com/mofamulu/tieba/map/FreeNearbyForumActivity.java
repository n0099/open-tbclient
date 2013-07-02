package com.mofamulu.tieba.map;

import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.at;
/* loaded from: classes.dex */
public class FreeNearbyForumActivity extends com.baidu.tieba.g {
    private Address a = null;
    private at b = null;
    private ListView c = null;
    private com.baidu.tieba.nearby.d d = null;
    private View.OnClickListener e = null;
    private ImageView f = null;
    private v g = null;
    private boolean j = false;
    private ProgressBar k = null;
    private boolean l = false;
    private ProgressBar m = null;
    private u n = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_forum_activity);
        b();
        c();
    }

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.f().v();
    }

    void b() {
        this.b = new at();
    }

    void c() {
        this.c = (ListView) findViewById(R.id.forum_list);
        this.e = new t(this);
        this.d = new com.baidu.tieba.nearby.d(this, this.b, this.e);
        this.c.setAdapter((ListAdapter) this.d);
        this.k = (ProgressBar) findViewById(R.id.forum_progress);
        this.m = (ProgressBar) findViewById(R.id.like_progress);
        this.f = (ImageView) findViewById(R.id.distance_line);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.n != null) {
            this.n.cancel();
            this.n = null;
        }
        if (this.k != null) {
            this.k.setVisibility(8);
        }
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.d.notifyDataSetChanged();
        if (i == 1) {
            this.f.setBackgroundResource(R.drawable.timeline_below_1);
        } else {
            this.f.setBackgroundResource(R.drawable.timeline_below);
        }
    }

    public void a(Address address, boolean z) {
        if (address != null) {
            this.a = address;
            if (!this.j) {
                if (this.g != null) {
                    this.g.cancel();
                    this.g = null;
                }
                this.j = true;
                this.k.setVisibility(0);
                this.g = new v(this, this.a, z);
                this.g.setPriority(3);
                this.g.execute(String.valueOf(com.baidu.tieba.data.g.a) + "c/f/lbs/forum");
            }
        }
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a
    public void a(String str) {
        if ((getParent() instanceof FreeNearbyActivity) && ((FreeNearbyActivity) getParent()).m() == 1) {
            super.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (!this.l) {
            this.l = true;
            if (this.n != null) {
                this.n.cancel();
                this.n = null;
            }
            this.n = new u(this, str, str2);
            this.n.setPriority(3);
            this.n.execute(new Object[0]);
        }
    }
}
