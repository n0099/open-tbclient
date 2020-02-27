package com.kascend.chushou.constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.toolkit.richtext.RichTextPlus;
/* loaded from: classes5.dex */
public class PrivilegeInfo {
    public boolean mShowAvatar = false;
    public String mAvatarFrame = "";
    public String mRole = "";
    public ArrayList<Integer> mPrivileges = new ArrayList<>();
    public ArrayList<String> mMedals = new ArrayList<>();
    public ArrayList<RichText> mRichNickname = new ArrayList<>();
    public ColorPrivileges mColorPrivileges = new ColorPrivileges();
    public RichTextPlus mCoolNickname = null;
    public RichTextPlus mCoolContent = null;
    public RichTextPlus mCoolMessage = null;
    public Set<Integer> mEmojiPrivileges = new HashSet();

    public void release() {
        this.mShowAvatar = false;
        this.mRole = null;
        if (this.mPrivileges != null) {
            this.mPrivileges.clear();
            this.mPrivileges = null;
        }
        if (this.mMedals != null) {
            this.mMedals.clear();
            this.mMedals = null;
        }
        this.mRichNickname = null;
        if (this.mColorPrivileges != null) {
            this.mColorPrivileges.mColors.clear();
            this.mColorPrivileges.mColors = null;
            this.mColorPrivileges = null;
        }
        this.mCoolNickname = null;
        this.mCoolContent = null;
        this.mCoolMessage = null;
        if (this.mEmojiPrivileges != null) {
            this.mEmojiPrivileges.clear();
            this.mEmojiPrivileges = null;
        }
    }
}
