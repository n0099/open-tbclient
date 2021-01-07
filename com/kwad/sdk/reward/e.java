package com.kwad.sdk.reward;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.BaseSystemDialogFragment;
/* loaded from: classes5.dex */
public class e extends BaseSystemDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static e f10951a;

    /* renamed from: b  reason: collision with root package name */
    private a f10952b;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void a(Activity activity, String str, a aVar) {
        f10951a = new e();
        Bundle bundle = new Bundle();
        bundle.putString("key_title", str);
        f10951a.setArguments(bundle);
        f10951a.a(aVar);
        f10951a.show(activity.getFragmentManager(), "videoCloseDialog");
    }

    private void a(a aVar) {
        this.f10952b = aVar;
    }

    public static boolean a() {
        return f10951a != null && f10951a.b();
    }

    public boolean b() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.f10952b != null) {
            this.f10952b.a();
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_title)).setText(getArguments().getString("key_title"));
        inflate.findViewById(R.id.ksad_close_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.f10952b != null) {
                    e.this.f10952b.b();
                }
            }
        });
        inflate.findViewById(R.id.ksad_continue_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.f10952b != null) {
                    e.this.f10952b.c();
                }
            }
        });
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.sdk.reward.e.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return inflate;
    }
}
