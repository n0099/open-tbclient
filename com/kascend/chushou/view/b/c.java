package com.kascend.chushou.view.b;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobstat.Config;
import com.kascend.chushou.a;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes5.dex */
public class c extends com.kascend.chushou.view.base.a {
    private TextView a;
    private TextView d;
    private TextView e;
    private TextView f;
    private String h;
    private String i;
    private int j;
    private String k;
    private FrescoThumbnailView mTO;
    private a mXZ;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str);
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putString("mid", str);
        bundle.putInt(Config.EVENT_HEAT_POINT, i);
        bundle.putString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, str2);
        bundle.putString("roomId", str3);
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, a.j.alert_dialog);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.h = arguments.getString("mid", "");
            this.j = arguments.getInt(Config.EVENT_HEAT_POINT);
            this.i = arguments.getString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
            this.k = arguments.getString("roomId", "");
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        a(-1, -2, 80, a.j.share_dialog_animation);
    }

    @Override // com.kascend.chushou.view.base.a
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.dialog_send_loyalfans, viewGroup, false);
        ((TextView) inflate.findViewById(a.f.tv_title)).setText(Html.fromHtml(this.b.getString(a.i.send_loyalfans)));
        ((RelativeLayout) inflate.findViewById(a.f.rl_top)).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismissAllowingStateLoss();
            }
        });
        this.a = (TextView) inflate.findViewById(a.f.tv_point);
        this.d = (TextView) inflate.findViewById(a.f.tv_cancel);
        this.e = (TextView) inflate.findViewById(a.f.tv_sure);
        this.mTO = (FrescoThumbnailView) inflate.findViewById(a.f.iv_icon);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.b.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismissAllowingStateLoss();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.b.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.mXZ != null) {
                    c.this.mXZ.a(c.this.j, c.this.h);
                }
            }
        });
        this.f = (TextView) inflate.findViewById(a.f.tv_look);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.b.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.k)) {
                    StringBuilder sb = new StringBuilder(com.kascend.chushou.c.c.a(27));
                    sb.append("?roomId=").append(c.this.k);
                    com.kascend.chushou.d.a.a(c.this.b, sb.toString(), "");
                }
            }
        });
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
        this.mTO.i(this.i, a.e.default_gift, b.a.nOY, b.a.nOY);
        this.a.setText(String.format(this.b.getString(a.i.send_loyalfans3), Integer.valueOf(this.j)));
    }

    public void a(a aVar) {
        this.mXZ = aVar;
    }
}
