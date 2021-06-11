package d.a.z.h.c;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes2.dex */
public class a extends Resources {

    /* renamed from: a  reason: collision with root package name */
    public Resources f68678a;

    public a(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration, Resources resources) {
        super(assetManager, displayMetrics, configuration);
        this.f68678a = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        try {
            return super.getAnimation(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getAnimation(i2);
        }
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) throws Resources.NotFoundException {
        try {
            return super.getBoolean(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getBoolean(i2);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) throws Resources.NotFoundException {
        try {
            return super.getColor(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getColor(i2);
        }
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        try {
            return super.getColorStateList(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getColorStateList(i2);
        }
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        try {
            return super.getConfiguration();
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getConfiguration();
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) throws Resources.NotFoundException {
        try {
            return super.getDimension(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getDimension(i2);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        try {
            return super.getDimensionPixelOffset(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getDimensionPixelOffset(i2);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        try {
            return super.getDimensionPixelSize(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getDimensionPixelSize(i2);
        }
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        try {
            return super.getDisplayMetrics();
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getDisplayMetrics();
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        try {
            return super.getDrawable(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getDrawable(i2);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        try {
            return super.getDrawableForDensity(i2, i3);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getDrawableForDensity(i2, i3);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(26)
    public Typeface getFont(int i2) throws Resources.NotFoundException {
        try {
            return super.getFont(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getFont(i2);
        }
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        try {
            return super.getFraction(i2, i3, i4);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getFraction(i2, i3, i4);
        }
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        try {
            return super.getIdentifier(str, str2, str3);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getIdentifier(str, str2, str3);
        }
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) throws Resources.NotFoundException {
        try {
            return super.getIntArray(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getIntArray(i2);
        }
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) throws Resources.NotFoundException {
        try {
            return super.getInteger(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getInteger(i2);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        try {
            return super.getLayout(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getLayout(i2);
        }
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) throws Resources.NotFoundException {
        try {
            return super.getMovie(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getMovie(i2);
        }
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        try {
            return super.getQuantityString(i2, i3, objArr);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getQuantityString(i2, i3, objArr);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        try {
            return super.getQuantityText(i2, i3);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getQuantityText(i2, i3);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) throws Resources.NotFoundException {
        try {
            return super.getResourceEntryName(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getResourceEntryName(i2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) throws Resources.NotFoundException {
        try {
            return super.getResourceName(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getResourceName(i2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) throws Resources.NotFoundException {
        try {
            return super.getResourcePackageName(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getResourcePackageName(i2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) throws Resources.NotFoundException {
        try {
            return super.getResourceTypeName(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getResourceTypeName(i2);
        }
    }

    @Override // android.content.res.Resources
    public String getString(int i2) throws Resources.NotFoundException {
        try {
            return super.getString(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getString(i2);
        }
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) throws Resources.NotFoundException {
        try {
            return super.getStringArray(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getStringArray(i2);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) throws Resources.NotFoundException {
        try {
            return super.getText(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getText(i2);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        try {
            return super.getTextArray(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getTextArray(i2);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        try {
            super.getValue(str, typedValue, z);
        } catch (Resources.NotFoundException unused) {
            this.f68678a.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        try {
            super.getValueForDensity(i2, i3, typedValue, z);
        } catch (Resources.NotFoundException unused) {
            this.f68678a.getValueForDensity(i2, i3, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        try {
            return super.getXml(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getXml(i2);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        try {
            return super.obtainAttributes(attributeSet, iArr);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.obtainAttributes(attributeSet, iArr);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        try {
            return super.obtainTypedArray(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.obtainTypedArray(i2);
        }
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        try {
            return super.openRawResource(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.openRawResource(i2);
        }
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        try {
            return super.openRawResourceFd(i2);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.openRawResourceFd(i2);
        }
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        try {
            super.parseBundleExtra(str, attributeSet, bundle);
        } catch (Resources.NotFoundException unused) {
            this.f68678a.parseBundleExtra(str, attributeSet, bundle);
        }
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws IOException, XmlPullParserException {
        try {
            super.parseBundleExtras(xmlResourceParser, bundle);
        } catch (Resources.NotFoundException unused) {
            this.f68678a.parseBundleExtras(xmlResourceParser, bundle);
        }
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        try {
            super.updateConfiguration(configuration, displayMetrics);
        } catch (Resources.NotFoundException unused) {
            this.f68678a.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(23)
    public int getColor(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getColor(i2, theme);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getColor(i2, theme);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(23)
    public ColorStateList getColorStateList(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getColorStateList(i2, theme);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getColorStateList(i2, theme);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getDrawable(i2, theme);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getDrawable(i2, theme);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i2, i3, theme);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getDrawableForDensity(i2, i3, theme);
        }
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        try {
            return super.getQuantityString(i2, i3);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getQuantityString(i2, i3);
        }
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        try {
            return super.getString(i2, objArr);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getString(i2, objArr);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        try {
            return super.getText(i2, charSequence);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.getText(i2, charSequence);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        try {
            super.getValue(i2, typedValue, z);
        } catch (Resources.NotFoundException unused) {
            this.f68678a.getValue(i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        try {
            return super.openRawResource(i2, typedValue);
        } catch (Resources.NotFoundException unused) {
            return this.f68678a.openRawResource(i2, typedValue);
        }
    }
}
