package com.kascend.chushou.constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class PannelItem implements Serializable {
    private static final long serialVersionUID = 5147506391323782042L;
    public String mBreakpoint;
    public String mIcon;
    public ListItem mMoreNav;
    public int mPannelPos;
    public boolean mSupportRefresh;
    public String mType;
    public String mDisplayName = "";
    public ArrayList<ListItem> mNavItemList = new ArrayList<>();

    public PannelItem copyAsHeader() {
        PannelItem pannelItem = new PannelItem();
        pannelItem.mType = "HEADER";
        pannelItem.mDisplayName = this.mDisplayName;
        pannelItem.mMoreNav = this.mMoreNav;
        pannelItem.mIcon = this.mIcon;
        pannelItem.mBreakpoint = this.mBreakpoint;
        pannelItem.mSupportRefresh = this.mSupportRefresh;
        pannelItem.mNavItemList = this.mNavItemList;
        return pannelItem;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PannelItem)) {
            return false;
        }
        PannelItem pannelItem = (PannelItem) obj;
        if (this.mNavItemList.size() == pannelItem.mNavItemList.size()) {
            for (int i = 0; i < pannelItem.mNavItemList.size(); i++) {
                if (!this.mNavItemList.get(i).equals(pannelItem.mNavItemList.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mNavItemList.toArray());
    }
}
