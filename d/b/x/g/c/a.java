package d.b.x.g.c;

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
    public Resources f65852a;

    public a(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration, Resources resources) {
        super(assetManager, displayMetrics, configuration);
        this.f65852a = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        try {
            return super.getAnimation(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getAnimation(i);
        }
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        try {
            return super.getBoolean(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getBoolean(i);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        try {
            return super.getColor(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getColor(i);
        }
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        try {
            return super.getColorStateList(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getColorStateList(i);
        }
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        try {
            return super.getConfiguration();
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getConfiguration();
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        try {
            return super.getDimension(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getDimension(i);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        try {
            return super.getDimensionPixelOffset(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getDimensionPixelOffset(i);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        try {
            return super.getDimensionPixelSize(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getDimensionPixelSize(i);
        }
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        try {
            return super.getDisplayMetrics();
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getDisplayMetrics();
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        try {
            return super.getDrawable(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getDrawable(i);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        try {
            return super.getDrawableForDensity(i, i2);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getDrawableForDensity(i, i2);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(26)
    public Typeface getFont(int i) throws Resources.NotFoundException {
        try {
            return super.getFont(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getFont(i);
        }
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        try {
            return super.getFraction(i, i2, i3);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getFraction(i, i2, i3);
        }
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        try {
            return super.getIdentifier(str, str2, str3);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getIdentifier(str, str2, str3);
        }
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        try {
            return super.getIntArray(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getIntArray(i);
        }
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        try {
            return super.getInteger(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getInteger(i);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        try {
            return super.getLayout(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getLayout(i);
        }
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        try {
            return super.getMovie(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getMovie(i);
        }
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        try {
            return super.getQuantityString(i, i2, objArr);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getQuantityString(i, i2, objArr);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        try {
            return super.getQuantityText(i, i2);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getQuantityText(i, i2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        try {
            return super.getResourceEntryName(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getResourceEntryName(i);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        try {
            return super.getResourceName(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getResourceName(i);
        }
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        try {
            return super.getResourcePackageName(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getResourcePackageName(i);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        try {
            return super.getResourceTypeName(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getResourceTypeName(i);
        }
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        try {
            return super.getString(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getString(i);
        }
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        try {
            return super.getStringArray(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getStringArray(i);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        try {
            return super.getText(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getText(i);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        try {
            return super.getTextArray(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getTextArray(i);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        try {
            super.getValue(str, typedValue, z);
        } catch (Resources.NotFoundException unused) {
            this.f65852a.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        try {
            super.getValueForDensity(i, i2, typedValue, z);
        } catch (Resources.NotFoundException unused) {
            this.f65852a.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        try {
            return super.getXml(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getXml(i);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        try {
            return super.obtainAttributes(attributeSet, iArr);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.obtainAttributes(attributeSet, iArr);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        try {
            return super.obtainTypedArray(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.obtainTypedArray(i);
        }
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        try {
            return super.openRawResource(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.openRawResource(i);
        }
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        try {
            return super.openRawResourceFd(i);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.openRawResourceFd(i);
        }
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        try {
            super.parseBundleExtra(str, attributeSet, bundle);
        } catch (Resources.NotFoundException unused) {
            this.f65852a.parseBundleExtra(str, attributeSet, bundle);
        }
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws IOException, XmlPullParserException {
        try {
            super.parseBundleExtras(xmlResourceParser, bundle);
        } catch (Resources.NotFoundException unused) {
            this.f65852a.parseBundleExtras(xmlResourceParser, bundle);
        }
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        try {
            super.updateConfiguration(configuration, displayMetrics);
        } catch (Resources.NotFoundException unused) {
            this.f65852a.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(23)
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getColor(i, theme);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getColor(i, theme);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(23)
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getColorStateList(i, theme);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getColorStateList(i, theme);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        try {
            return super.getDrawable(i, theme);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getDrawable(i, theme);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i, i2, theme);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getDrawableForDensity(i, i2, theme);
        }
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        try {
            return super.getQuantityString(i, i2);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getQuantityString(i, i2);
        }
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        try {
            return super.getString(i, objArr);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getString(i, objArr);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        try {
            return super.getText(i, charSequence);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.getText(i, charSequence);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        try {
            super.getValue(i, typedValue, z);
        } catch (Resources.NotFoundException unused) {
            this.f65852a.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        try {
            return super.openRawResource(i, typedValue);
        } catch (Resources.NotFoundException unused) {
            return this.f65852a.openRawResource(i, typedValue);
        }
    }
}
