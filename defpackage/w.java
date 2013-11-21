package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: w  reason: default package */
/* loaded from: classes.dex */
public class w implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShareDialog f2974a;

    public w(ShareDialog shareDialog) {
        this.f2974a = shareDialog;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f2974a.e = editable.toString();
        int length = this.f2974a.mMaxLength - editable.length();
        ShareDialog.mCounterView.setText(String.valueOf(length));
        if (length <= 10) {
            ShareDialog.mCounterView.setTextColor(-65536);
        } else {
            ShareDialog.mCounterView.setTextColor(-5658199);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
