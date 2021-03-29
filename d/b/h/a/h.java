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
/* loaded from: classes.dex */
public class h extends Resources {

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, d.b.h.a.k.e<String, Integer>> f49451d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public Resources f49452a;

    /* renamed from: b  reason: collision with root package name */
    public String f49453b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f49454c;

    static {
        String str = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    }

    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.f49454c = resources;
        new HashMap();
    }

    public int a(int i) {
        if (!TextUtils.isEmpty(this.f49453b) && !this.f49453b.equals("com.baidu.browser.theme.default")) {
            try {
                String resourceEntryName = this.f49454c.getResourceEntryName(i);
                String resourceTypeName = this.f49454c.getResourceTypeName(i);
                d.b.h.a.k.e<String, Integer> eVar = f49451d.get(resourceTypeName);
                if (eVar == null) {
                    eVar = new d.b.h.a.k.e<>(100);
                    f49451d.put(resourceTypeName, eVar);
                }
                Integer c2 = eVar.c(resourceEntryName);
                if (c2 == null) {
                    c2 = Integer.valueOf(this.f49452a.getIdentifier(resourceEntryName, resourceTypeName, this.f49453b));
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
            return this.f49452a.getAnimation(a2);
        }
        return this.f49454c.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.f49454c.getBoolean(i);
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
        return this.f49454c.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getDimension(a2);
        }
        return this.f49454c.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getDimensionPixelOffset(a2);
        }
        return this.f49454c.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getDimensionPixelSize(a2);
        }
        return this.f49454c.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getDrawable(a2);
        }
        return this.f49454c.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getDrawableForDensity(a2, i2);
        }
        return this.f49454c.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getFraction(a2, i2, i3);
        }
        return this.f49454c.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getIntArray(a2);
        }
        return this.f49454c.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getInteger(a2);
        }
        return this.f49454c.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getLayout(a2);
        }
        return this.f49454c.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getMovie(a2);
        }
        return this.f49454c.getMovie(i);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getQuantityString(a2, i2);
        }
        return this.f49454c.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getQuantityText(a2, i2);
        }
        return this.f49454c.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.f49454c.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.f49454c.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.f49454c.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.f49454c.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getString(a2);
        }
        return this.f49454c.getString(i);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getStringArray(a2);
        }
        return this.f49454c.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getText(a2);
        }
        return this.f49454c.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getTextArray(a2);
        }
        return this.f49454c.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            this.f49452a.getValue(a2, typedValue, z);
        } else {
            this.f49454c.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            this.f49452a.getValueForDensity(a2, i2, typedValue, z);
        } else {
            this.f49454c.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.f49454c.getXml(i);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f49454c.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.f49454c.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i);
        if (a2 != 0 && (resources = this.f49452a) != null) {
            try {
                InputStream openRawResource = resources.openRawResource(a2);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f49454c.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i);
        if (a2 != 0 && (resources = this.f49452a) != null) {
            try {
                AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(a2);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f49454c.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getColor(a2);
        }
        return this.f49454c.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getColorStateList(a2);
        }
        return this.f49454c.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getDrawable(a2, null);
        }
        return this.f49454c.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getQuantityString(a2, i2, objArr);
        }
        return this.f49454c.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getString(a2, objArr);
        }
        return this.f49454c.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int a2 = a(i);
        if (a2 != 0) {
            return this.f49452a.getText(a2, charSequence);
        }
        return this.f49454c.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f49454c.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i);
        if (a2 != 0 && (resources = this.f49452a) != null) {
            try {
                InputStream openRawResource = resources.openRawResource(a2, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f49454c.openRawResource(i, typedValue);
    }
}
