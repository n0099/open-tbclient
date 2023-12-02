package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class a implements View.OnClickListener {
    @Nullable
    public TextView II;
    @Nullable
    public ImageView IJ;
    @Nullable
    public ImageView IK;
    @Nullable
    public InterfaceC0632a IL;
    public ViewGroup sy;

    /* renamed from: com.kwad.components.core.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0632a {
        void u(View view2);

        void v(View view2);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913a8);
        this.sy = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    public final void a(@Nullable InterfaceC0632a interfaceC0632a) {
        this.IL = interfaceC0632a;
    }

    @MainThread
    public final void ah(boolean z) {
        int i;
        ImageView imageView = this.IK;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (this.IL == null) {
            return;
        }
        if (view2.equals(this.IK)) {
            this.IL.v(view2);
        } else if (view2.equals(this.IJ)) {
            this.IL.u(view2);
        }
    }

    private void initView() {
        this.II = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913a5);
        this.IJ = (ImageView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913a6);
        ImageView imageView = (ImageView) this.sy.findViewById(R.id.obfuscated_res_0x7f0913a7);
        this.IK = imageView;
        imageView.setOnClickListener(this);
        this.IJ.setOnClickListener(this);
    }

    public final ViewGroup gD() {
        return this.sy;
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.sy != null && (textView = this.II) != null) {
            textView.setText(bVar.getTitle());
        }
    }
}
