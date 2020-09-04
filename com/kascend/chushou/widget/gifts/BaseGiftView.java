package com.kascend.chushou.widget.gifts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.kascend.chushou.constants.GeneralGift;
import com.kascend.chushou.constants.GiftPanelStatus;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class BaseGiftView extends RelativeLayout {
    protected View a;
    protected View c;
    protected int e;
    protected Object f;
    public boolean g;
    protected boolean h;
    protected a obn;
    protected GeneralGift obo;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);

        void a(Object obj);

        void b(int i);

        void b(View view, Object obj, int i, String str);
    }

    public BaseGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.obo = null;
        this.e = -1;
        this.f = null;
        this.g = false;
        this.h = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a = null;
        this.f = null;
    }

    public void setViewListener(a aVar) {
        this.obn = aVar;
    }

    public View getCurGiftView() {
        return this.c;
    }

    public GeneralGift getCurObj() {
        return this.obo;
    }

    public int getCurSelectPos() {
        return this.e;
    }

    public void a(ArrayList<GeneralGift> arrayList, String str, int i, boolean z) {
    }

    public void a(GiftPanelStatus giftPanelStatus) {
    }

    public void a(List<GeneralGift> list, String str, int i, boolean z) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return this.h;
    }
}
