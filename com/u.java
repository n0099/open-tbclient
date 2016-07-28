package com;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class u implements TextWatcher {
    final /* synthetic */ ShareDialog dE;

    public u(ShareDialog shareDialog) {
        this.dE = shareDialog;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.dE.a(this.dE.mMaxLength - editable.length());
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
