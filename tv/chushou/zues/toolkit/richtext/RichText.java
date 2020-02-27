package tv.chushou.zues.toolkit.richtext;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class RichText implements Serializable, Cloneable {
    public static final int FONTSTYLE_BOLD = 1;
    public static final int FONTSTYLE_ITALIC = 2;
    public static final int FONTSTYLE_UNDERLINE = 4;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_LINK = 3;
    public static final int TYPE_LOCAL_DRAWABLE = 5;
    public static final int TYPE_NORMAL = -1;
    public static final int TYPE_RICHTEXT = 1;
    private static final long serialVersionUID = -601848252661601162L;
    public String mBackgroundColor;
    public int mCombo;
    public String mContent;
    public int mDrawableId;
    public String mFontColor;
    public int mFontSizeLevel;
    public int mFontStyle = 0;
    public String mImage;
    public int mType;
    public String mUrl;
    public String mUrlDesc;

    public String toString() {
        return "type=" + this.mType + " content=" + this.mContent + " fontcolor=" + this.mFontColor + " fontsizelevel=" + this.mFontSizeLevel + " background=" + this.mBackgroundColor + " fontstyle=" + this.mFontStyle + " mimage=" + this.mImage + " urldesc=" + this.mUrlDesc + " url=" + this.mUrl + " combo=" + this.mCombo + " drawableId=" + this.mDrawableId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public RichText clone() {
        RichText richText = new RichText();
        richText.mFontColor = this.mFontColor;
        richText.mFontSizeLevel = this.mFontSizeLevel;
        richText.mBackgroundColor = this.mBackgroundColor;
        richText.mFontStyle = this.mFontStyle;
        richText.mContent = this.mContent;
        richText.mImage = this.mImage;
        richText.mUrlDesc = this.mUrlDesc;
        richText.mUrl = this.mUrl;
        richText.mType = this.mType;
        richText.mCombo = this.mCombo;
        richText.mDrawableId = this.mDrawableId;
        return richText;
    }
}
