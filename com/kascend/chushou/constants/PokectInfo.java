package com.kascend.chushou.constants;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class PokectInfo implements Serializable {
    private static final long serialVersionUID = 7775125423629438717L;
    public String mCornerImage;
    public int mCount;
    public String mType = "";
    public String mPokectId = "";
    public String mPokectName = "";
    public String mPokectIcon = "";
    public String mBg = "";

    public void release() {
        this.mType = null;
        this.mPokectId = null;
        this.mPokectName = null;
        this.mPokectIcon = null;
        this.mBg = null;
    }
}
