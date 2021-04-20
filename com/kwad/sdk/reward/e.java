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
/* loaded from: classes6.dex */
public class e extends BaseSystemDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static e f36748a;

    /* renamed from: b  reason: collision with root package name */
    public a f36749b;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void a(Activity activity, String str, a aVar) {
        f36748a = new e();
        Bundle bundle = new Bundle();
        bundle.putString("key_title", str);
        f36748a.setArguments(bundle);
        f36748a.a(aVar);
        f36748a.show(activity.getFragmentManager(), "videoCloseDialog");
    }

    private void a(a aVar) {
        this.f36749b = aVar;
    }

    public static boolean a() {
        e eVar = f36748a;
        return eVar != null && eVar.b();
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
        a aVar = this.f36749b;
        if (aVar != null) {
            aVar.a();
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
                if (e.this.f36749b != null) {
                    e.this.f36749b.b();
                }
            }
        });
        inflate.findViewById(R.id.ksad_continue_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.reward.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.f36749b != null) {
                    e.this.f36749b.c();
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
