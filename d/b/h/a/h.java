package d.b.h.a;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class h extends Resources {

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, d.b.h.a.k.e<String, Integer>> f49450d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public Resources f49451a;

    /* renamed from: b  reason: collision with root package name */
    public String f49452b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f49453c;

    static {
        String str = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    }

    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.f49453c = resources;
        new HashMap();
    }

    public int a(int i) {
        if (!TextUtils.isEmpty(this.f49452b) && !this.f49452b.equals("com.baidu.browser.theme.default")) {
            try {
                String resourceEntryName = this.f49453c.getResourceEntryName(i);
                String resourceTypeName = this.f49453c.getResourceTypeName(i);
                d.b.h.a.k.e<String, Integer> eVar = f49450d.get(resourceTypeName);
                if (eVar == null) {
                    eVar = new d.b.h.a.k.e<>(100);
                    f49450d.put(resourceTypeName, eVar);
                }
                Integer c2 = eVar.c(resourceEntryName);
                if (c2 == null) {
                    c2 = Integer.valueOf(this.f49451a.getIdentifier(resourceEntryName, resourceTypeName, this.f49452b));
                    if (c2.intValue() != 0) {
                        eVar.d(resourceEntryName, c2);
                    }
                }
                return c2.intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getAnimation(a2);
        }
        return this.f49453c.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.f49453c.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        return getColor(i, null);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return getColorStateList(i, null);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f49453c.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getDimension(a2);
        }
        return this.f49453c.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getDimensionPixelOffset(a2);
        }
        return this.f49453c.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getDimensionPixelSize(a2);
        }
        return this.f49453c.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getDrawable(a2);
        }
        return this.f49453c.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getDrawableForDensity(a2, i2);
        }
        return this.f49453c.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getFraction(a2, i2, i3);
        }
        return this.f49453c.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getIntArray(a2);
        }
        return this.f49453c.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getInteger(a2);
        }
        return this.f49453c.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getLayout(a2);
        }
        return this.f49453c.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getMovie(a2);
        }
        return this.f49453c.getMovie(i);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getQuantityString(a2, i2);
        }
        return this.f49453c.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getQuantityText(a2, i2);
        }
        return this.f49453c.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.f49453c.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.f49453c.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.f49453c.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.f49453c.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getString(a2);
        }
        return this.f49453c.getString(i);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getStringArray(a2);
        }
        return this.f49453c.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getText(a2);
        }
        return this.f49453c.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getTextArray(a2);
        }
        return this.f49453c.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            this.f49451a.getValue(a2, typedValue, z);
        } else {
            this.f49453c.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            this.f49451a.getValueForDensity(a2, i2, typedValue, z);
        } else {
            this.f49453c.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.f49453c.getXml(i);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f49453c.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.f49453c.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i);
        if (a2 != 0 && (resources = this.f49451a) != null) {
            try {
                InputStream openRawResource = resources.openRawResource(a2);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f49453c.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i);
        if (a2 != 0 && (resources = this.f49451a) != null) {
            try {
                AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(a2);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f49453c.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getColor(a2);
        }
        return this.f49453c.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getColorStateList(a2);
        }
        return this.f49453c.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getDrawable(a2, null);
        }
        return this.f49453c.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getQuantityString(a2, i2, objArr);
        }
        return this.f49453c.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getString(a2, objArr);
        }
        return this.f49453c.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49451a.getText(a2, charSequence);
        }
        return this.f49453c.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f49453c.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i);
        if (a2 != 0 && (resources = this.f49451a) != null) {
            try {
                InputStream openRawResource = resources.openRawResource(a2, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f49453c.openRawResource(i, typedValue);
    }
}
