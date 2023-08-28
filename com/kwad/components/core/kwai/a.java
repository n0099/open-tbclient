package com.kwad.components.core.kwai;

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
    public ImageView CO;
    @Nullable
    public ImageView CP;
    @Nullable
    public InterfaceC0654a CQ;
    @Nullable
    public TextView mTitle;
    public ViewGroup pV;

    /* renamed from: com.kwad.components.core.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0654a {
        void r(View view2);

        void s(View view2);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f091309);
        this.pV = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.mTitle = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091306);
        this.CO = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091307);
        ImageView imageView = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091308);
        this.CP = imageView;
        imageView.setOnClickListener(this);
        this.CO.setOnClickListener(this);
    }

    public final void a(@Nullable InterfaceC0654a interfaceC0654a) {
        this.CQ = interfaceC0654a;
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.pV == null || (textView = this.mTitle) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }

    @MainThread
    public final void ag(boolean z) {
        ImageView imageView = this.CP;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @MainThread
    public final void ah(boolean z) {
        ImageView imageView = this.CO;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (this.CQ == null) {
            return;
        }
        if (view2.equals(this.CP)) {
            this.CQ.s(view2);
        } else if (view2.equals(this.CO)) {
            this.CQ.r(view2);
        }
    }
}
