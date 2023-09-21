package com.bytedance.tools.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FoldSpinnerView extends LinearLayout {
    public View a;
    public TextView b;
    public ImageView c;
    public String d;
    public boolean e;

    public void b(boolean z) {
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FoldSpinnerView foldSpinnerView = FoldSpinnerView.this;
            foldSpinnerView.e = !foldSpinnerView.e;
            FoldSpinnerView.this.a();
        }
    }

    public FoldSpinnerView(Context context) {
        super(context);
        this.e = false;
        e();
    }

    private void setChildVisible(int i) {
        int childCount = getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            getChildAt(i2).setVisibility(i);
        }
    }

    public void setIsFold(boolean z) {
        this.e = z;
    }

    public void setTitleText(String str) {
        this.d = str;
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public FoldSpinnerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0407f1});
        this.d = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        e();
    }

    public FoldSpinnerView(Context context, String str, boolean z) {
        super(context);
        this.e = false;
        this.d = str;
        this.e = z;
        e();
    }

    public void a() {
        int i;
        int i2;
        ImageView imageView = this.c;
        if (this.e) {
            i = R.drawable.obfuscated_res_0x7f080219;
        } else {
            i = R.drawable.obfuscated_res_0x7f080215;
        }
        imageView.setImageResource(i);
        if (this.e) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        setChildVisible(i2);
        b(this.e);
    }

    public String getTitleText() {
        return this.d;
    }

    public final void e() {
        setBackgroundColor(-1);
        setOrientation(1);
        addView(LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0a04, (ViewGroup) this, false));
        this.a = findViewById(R.id.obfuscated_res_0x7f092977);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092976);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f092975);
        this.a.setOnClickListener(new a());
        this.b.setText(this.d);
    }
}
