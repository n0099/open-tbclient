package com.kascend.chushou.player.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
/* loaded from: classes6.dex */
public class PlayerErrorView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f4142a;

    public PlayerErrorView(Context context) {
        this(context, null);
    }

    public PlayerErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4142a = context;
        a(context);
    }

    private void a(Context context) {
        addView(LayoutInflater.from(context).inflate(a.h.player_error_view, (ViewGroup) this, false));
    }

    public void setText(int i) {
        TextView textView = (TextView) findViewById(a.f.tv_desc);
        if (textView != null) {
            textView.setText(this.f4142a.getString(i));
        }
    }
}
