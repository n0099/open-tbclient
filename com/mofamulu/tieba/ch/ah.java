package com.mofamulu.tieba.ch;

import android.widget.RadioGroup;
import java.util.HashMap;
/* loaded from: classes.dex */
class ah implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ MoreNickActivity a;
    private final /* synthetic */ HashMap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(MoreNickActivity moreNickActivity, HashMap hashMap) {
        this.a = moreNickActivity;
        this.b = hashMap;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.a.g.a(((Long) this.b.get(Integer.valueOf(i))).longValue());
    }
}
