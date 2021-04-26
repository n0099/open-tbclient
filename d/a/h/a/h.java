package d.a.h.a;

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
    public static HashMap<String, d.a.h.a.k.e<String, Integer>> f41027d = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public Resources f41028a;

    /* renamed from: b  reason: collision with root package name */
    public String f41029b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f41030c;

    static {
        String str = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    }

    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.f41030c = resources;
        new HashMap();
    }

    public int a(int i2) {
        if (!TextUtils.isEmpty(this.f41029b) && !this.f41029b.equals("com.baidu.browser.theme.default")) {
            try {
                String resourceEntryName = this.f41030c.getResourceEntryName(i2);
                String resourceTypeName = this.f41030c.getResourceTypeName(i2);
                d.a.h.a.k.e<String, Integer> eVar = f41027d.get(resourceTypeName);
                if (eVar == null) {
                    eVar = new d.a.h.a.k.e<>(100);
                    f41027d.put(resourceTypeName, eVar);
                }
                Integer c2 = eVar.c(resourceEntryName);
                if (c2 == null) {
                    c2 = Integer.valueOf(this.f41028a.getIdentifier(resourceEntryName, resourceTypeName, this.f41029b));
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
    public XmlResourceParser getAnimation(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getAnimation(a2);
        }
        return this.f41030c.getAnimation(i2);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) throws Resources.NotFoundException {
        return this.f41030c.getBoolean(i2);
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) throws Resources.NotFoundException {
        return getColor(i2, null);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) throws Resources.NotFoundException {
        return getColorStateList(i2, null);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f41030c.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getDimension(a2);
        }
        return this.f41030c.getDimension(i2);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getDimensionPixelOffset(a2);
        }
        return this.f41030c.getDimensionPixelOffset(i2);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getDimensionPixelSize(a2);
        }
        return this.f41030c.getDimensionPixelSize(i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getDrawable(a2);
        }
        return this.f41030c.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i2, int i3) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getDrawableForDensity(a2, i3);
        }
        return this.f41030c.getDrawableForDensity(i2, i3);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i2, int i3, int i4) {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getFraction(a2, i3, i4);
        }
        return this.f41030c.getFraction(i2, i3, i4);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getIntArray(a2);
        }
        return this.f41030c.getIntArray(i2);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getInteger(a2);
        }
        return this.f41030c.getInteger(i2);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getLayout(a2);
        }
        return this.f41030c.getLayout(i2);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getMovie(a2);
        }
        return this.f41030c.getMovie(i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getQuantityString(a2, i3);
        }
        return this.f41030c.getQuantityString(i2, i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getQuantityText(a2, i3);
        }
        return this.f41030c.getQuantityText(i2, i3);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) throws Resources.NotFoundException {
        return this.f41030c.getResourceEntryName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) throws Resources.NotFoundException {
        return this.f41030c.getResourceName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) throws Resources.NotFoundException {
        return this.f41030c.getResourcePackageName(i2);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) throws Resources.NotFoundException {
        return this.f41030c.getResourceTypeName(i2);
    }

    @Override // android.content.res.Resources
    public String getString(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getString(a2);
        }
        return this.f41030c.getString(i2);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getStringArray(a2);
        }
        return this.f41030c.getStringArray(i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getText(a2);
        }
        return this.f41030c.getText(i2);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getTextArray(a2);
        }
        return this.f41030c.getTextArray(i2);
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            this.f41028a.getValue(a2, typedValue, z);
        } else {
            this.f41030c.getValue(i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            this.f41028a.getValueForDensity(a2, i3, typedValue, z);
        } else {
            this.f41030c.getValueForDensity(i2, i3, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) throws Resources.NotFoundException {
        return this.f41030c.getXml(i2);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f41030c.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) throws Resources.NotFoundException {
        return this.f41030c.obtainTypedArray(i2);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i2);
        if (a2 != 0 && (resources = this.f41028a) != null) {
            try {
                InputStream openRawResource = resources.openRawResource(a2);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f41030c.openRawResource(i2);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i2);
        if (a2 != 0 && (resources = this.f41028a) != null) {
            try {
                AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(a2);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f41030c.openRawResourceFd(i2);
    }

    @Override // android.content.res.Resources
    public int getColor(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getColor(a2);
        }
        return this.f41030c.getColor(i2);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getColorStateList(a2);
        }
        return this.f41030c.getColorStateList(i2);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i2, Resources.Theme theme) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getDrawable(a2, null);
        }
        return this.f41030c.getDrawable(i2, theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getQuantityString(a2, i3, objArr);
        }
        return this.f41030c.getQuantityString(i2, i3, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) throws Resources.NotFoundException {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getString(a2, objArr);
        }
        return this.f41030c.getString(i2, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2, CharSequence charSequence) {
        int a2 = a(i2);
        if (a2 != 0) {
            return this.f41028a.getText(a2, charSequence);
        }
        return this.f41030c.getText(i2, charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f41030c.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) throws Resources.NotFoundException {
        Resources resources;
        int a2 = a(i2);
        if (a2 != 0 && (resources = this.f41028a) != null) {
            try {
                InputStream openRawResource = resources.openRawResource(a2, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f41030c.openRawResource(i2, typedValue);
    }
}
