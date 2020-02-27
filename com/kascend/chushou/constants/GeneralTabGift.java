package com.kascend.chushou.constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class GeneralTabGift implements Serializable {
    private static final long serialVersionUID = -5435240163993175681L;
    public boolean mFrequentlyUsedTab;
    public String mName = "";
    public List<GeneralGift> mGeneralGifts = new ArrayList();

    public GeneralTabGift deepClone() {
        GeneralTabGift generalTabGift = new GeneralTabGift();
        generalTabGift.mName = this.mName;
        generalTabGift.mFrequentlyUsedTab = this.mFrequentlyUsedTab;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mGeneralGifts.size()) {
                GeneralGift generalGift = new GeneralGift();
                generalGift.copyClone(this.mGeneralGifts.get(i2));
                generalTabGift.mGeneralGifts.add(generalGift);
                i = i2 + 1;
            } else {
                return generalTabGift;
            }
        }
    }

    public void release() {
        if (this.mGeneralGifts != null) {
            this.mGeneralGifts.clear();
        }
    }
}
