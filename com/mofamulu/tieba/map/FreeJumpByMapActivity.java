package com.mofamulu.tieba.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.av;
import com.baidu.tieba.model.aw;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mofamulu.tieba.ch.NickBinder;
import com.mofamulu.tieba.ch.bg;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FreeJumpByMapActivity extends android.support.v4.app.n {
    FreeLocationService a;
    private GoogleMap b;
    private ViewGroup c = null;
    private View d = null;
    private ImageView e = null;
    private TextView f = null;
    private Button g = null;
    private com.baidu.tieba.util.a h;
    private g i;
    private HashMap j;

    public static void a(Activity activity, int i, int i2) {
        Intent intent = new Intent(activity, FreeJumpByMapActivity.class);
        intent.putExtra("zoom", i2);
        activity.startActivityForResult(intent, i);
    }

    private void d() {
        if (this.b == null) {
            this.b = ((SupportMapFragment) getSupportFragmentManager().a(R.id.map)).A();
            if (this.b != null) {
                a();
            }
        }
    }

    protected void a() {
        this.g.setClickable(true);
        this.g.setEnabled(true);
        this.b.a(bg.c().W());
        this.b.a(new b(this));
        this.b.a(new c(this));
        this.b.a(new d(this));
        int intExtra = getIntent().getIntExtra("zoom", 0);
        CameraPosition.Builder a = new CameraPosition.Builder().a(new LatLng(this.a.c(), this.a.d()));
        if (intExtra <= 1) {
            intExtra = 13;
        }
        this.b.a(CameraUpdateFactory.a(a.a(intExtra).b(0.0f).a()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tbhp_jump_by_map);
        this.a = FreeLocationService.a(this);
        this.h = new com.baidu.tieba.util.a(this);
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        d();
    }

    protected void b() {
        if (this.c == null) {
            this.c = (ViewGroup) findViewById(R.id.container);
            if (this.c == null) {
                this.c = (ViewGroup) findViewById(R.id.parent);
            }
            this.d = findViewById(R.id.title);
            this.e = (ImageView) findViewById(R.id.back);
            if (this.e != null) {
                this.e.setOnClickListener(new e(this));
            }
            this.f = (TextView) findViewById(R.id.title_text);
        }
        this.g = (Button) findViewById(R.id.save);
        int as = TiebaApplication.f().as();
        com.baidu.tieba.util.x.a(this.e, as);
        com.baidu.tieba.util.x.d(this.d, as);
        com.baidu.tieba.util.x.f(this.f, as);
        com.baidu.tieba.util.x.g((TextView) this.g, as);
        d();
    }

    protected void c() {
        this.g.setOnClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        setResult(z ? -1 : 0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(av avVar) {
        boolean z;
        if (this.j == null) {
            if (this.b != null) {
                this.b.a(CameraUpdateFactory.a(avVar.b()));
            }
            this.j = new HashMap();
            Iterator it = avVar.a().iterator();
            while (it.hasNext()) {
                aw awVar = (aw) it.next();
                if (awVar.a() == 0) {
                    a(awVar);
                } else if (awVar.a() == 101) {
                    awVar.a(100);
                }
            }
            return;
        }
        Iterator it2 = avVar.a().iterator();
        while (it2.hasNext()) {
            aw awVar2 = (aw) it2.next();
            if (awVar2.a() == 0) {
                String h = awVar2.h();
                if (h != null) {
                    Iterator it3 = this.j.values().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        } else if (h.equals(((aw) it3.next()).h())) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        a(awVar2);
                    }
                }
            } else if (awVar2.a() == 101) {
                awVar2.a(100);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(aw awVar) {
        BitmapDescriptor bitmapDescriptor;
        com.baidu.adp.widget.a.b b;
        String o = awVar.o();
        String n = awVar.n();
        if (o != null && n != null && awVar.l() != null) {
            try {
                String name = awVar.l().getName();
                if (name != null) {
                    com.mofamulu.tieba.ch.av avVar = (com.mofamulu.tieba.ch.av) NickBinder.b.a(name);
                    if (avVar == null || avVar.c() == 0 || (b = this.h.b(awVar.l().getPortrait())) == null) {
                        bitmapDescriptor = null;
                    } else {
                        bitmapDescriptor = BitmapDescriptorFactory.a(b.f());
                    }
                    this.j.put(this.b.a(new MarkerOptions().a(new LatLng(Double.parseDouble(o), Double.parseDouble(n))).a(awVar.l().getName_show()).b(awVar.f()).a(bitmapDescriptor)), awVar);
                }
            } catch (Throwable th) {
            }
        }
    }
}
