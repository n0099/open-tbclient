package com.kascend.chushou.constants;
/* loaded from: classes4.dex */
public class PrivacyItem {
    public boolean group;
    public int mId;
    public int mItemPosition;
    public int mParentId;
    public boolean mPopShow;
    public int mState;
    public int mType;
    public String mText = "";
    public String mWebIcon = "";
    public boolean mShowing = true;
    public boolean mMulti = false;

    /* loaded from: classes4.dex */
    public class TYPE {
        public static final int ITEMS_CHECK = 3;
        public static final int ITEMS_POP_CHECK = 5;
        public static final int ITEMS_POP_TOGGLE = 4;
        public static final int ITEM_TOGGLE = 2;
        public static final int TEXT_DESC = 0;

        public TYPE() {
        }
    }

    /* loaded from: classes4.dex */
    public class STATE {
        public static final int STATUS_CLOSE = 0;
        public static final int STATUS_LOADING = 2;
        public static final int STATUS_OPEN = 1;
        public static final int STATUS_UNKNOWN = 3;

        public STATE() {
        }
    }

    /* loaded from: classes4.dex */
    public class ITEMPOSITION {
        public static final int BOTTOM = 5;
        public static final int BOTTOM_LINE = 7;
        public static final int CENTER = 4;
        public static final int FIRST = 2;
        public static final int FIRST_WITH_MARGIN = 3;
        public static final int NO_LINE = 6;
        public static final int SINGLE = 0;
        public static final int SINGLE_WITH_MARGIN = 1;

        public ITEMPOSITION() {
        }
    }
}
