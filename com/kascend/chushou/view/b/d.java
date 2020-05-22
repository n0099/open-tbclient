package com.kascend.chushou.view.b;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.db.TableDefine;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.b;
import com.kascend.chushou.a;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class d extends com.kascend.chushou.view.base.a implements View.OnClickListener {
    private TextView e;
    private TextView f;
    private String g;
    private LinearLayout h;
    private FrescoThumbnailView mTI;
    private SimpleDraweeSpanTextView mYb;
    private a mYc;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public void a(a aVar) {
        this.mYc = aVar;
    }

    public static d QE(String str) {
        Bundle bundle = new Bundle();
        d dVar = new d();
        bundle.putString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, str);
        dVar.setArguments(bundle);
        return dVar;
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.g = arguments.getString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
        }
    }

    @Override // com.kascend.chushou.view.base.a
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.dialog_show_unsubscribe, viewGroup, false);
        this.mTI = (FrescoThumbnailView) inflate.findViewById(a.f.ivHead);
        this.mYb = (SimpleDraweeSpanTextView) inflate.findViewById(a.f.tvContent);
        this.e = (TextView) inflate.findViewById(a.f.tvSure);
        this.e.setOnClickListener(this);
        this.f = (TextView) inflate.findViewById(a.f.tvCancel);
        this.f.setOnClickListener(this);
        this.h = (LinearLayout) inflate.findViewById(a.f.llContent);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
        super.a(view);
        this.h.setVisibility(0);
        this.mTI.i(this.g, com.kascend.chushou.view.a.a(""), tv.chushou.zues.utils.a.dip2px(this.b, 36.0f), tv.chushou.zues.utils.a.dip2px(this.b, 36.0f));
        this.f.setText(getString(a.i.cs_exit_subscribes));
        this.e.setText(getString(a.i.quit_str));
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        cVar.J(this.b, a.e.cs_unsubcribe_emjio).append(getString(a.i.cs_follow_me));
        cVar.a(new b.c() { // from class: com.kascend.chushou.view.b.d.1
            @Override // com.facebook.drawee.span.b.c
            public void d(com.facebook.drawee.span.b bVar) {
                if (d.this.mYb != null) {
                    d.this.mYb.measure(0, 0);
                    d.this.mYb.requestLayout();
                }
            }
        });
        this.mYb.setDraweeSpanStringBuilder(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.tvCancel) {
            if (this.mYc != null) {
                this.mYc.a();
            }
        } else if (id == a.f.tvSure && this.mYc != null) {
            this.mYc.b();
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        a(tv.chushou.zues.utils.a.dip2px(this.b, 300.0f), -2, 17, -1);
    }
}
