package org.acra.collector;

import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
/* loaded from: classes.dex */
public class MediaCodecListCollector {
    private static Class e;
    private static Method f;
    private static Class g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Method k;
    private static Class l;
    private static Field m;
    private static Field n;
    private static Field o;
    private static Field p;
    private static final String[] a = {"mp4", "mpeg4", "MP4", "MPEG4"};
    private static final String[] b = {"avc", "h264", "AVC", "H264"};
    private static final String[] c = {"h263", "H263"};
    private static final String[] d = {"aac", "AAC"};
    private static SparseArray q = new SparseArray();
    private static SparseArray r = new SparseArray();
    private static SparseArray s = new SparseArray();
    private static SparseArray t = new SparseArray();
    private static SparseArray u = new SparseArray();
    private static SparseArray v = new SparseArray();
    private static SparseArray w = new SparseArray();
    private static SparseArray x = new SparseArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum CodecType {
        AVC,
        H263,
        MPEG4,
        AAC
    }

    static {
        Field[] fields;
        Field[] fields2;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        try {
            e = Class.forName("android.media.MediaCodecList");
            f = e.getMethod("getCodecInfoAt", Integer.TYPE);
            g = Class.forName("android.media.MediaCodecInfo");
            h = g.getMethod("getName", new Class[0]);
            i = g.getMethod("isEncoder", new Class[0]);
            j = g.getMethod("getSupportedTypes", new Class[0]);
            k = g.getMethod("getCapabilitiesForType", String.class);
            l = Class.forName("android.media.MediaCodecInfo$CodecCapabilities");
            m = l.getField("colorFormats");
            n = l.getField("profileLevels");
            for (Field field : l.getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && field.getName().startsWith("COLOR_")) {
                    q.put(field.getInt(null), field.getName());
                }
            }
            Class<?> cls = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
            for (Field field2 : cls.getFields()) {
                if (Modifier.isStatic(field2.getModifiers()) && Modifier.isFinal(field2.getModifiers())) {
                    if (field2.getName().startsWith("AVCLevel")) {
                        r.put(field2.getInt(null), field2.getName());
                    } else if (field2.getName().startsWith("AVCProfile")) {
                        s.put(field2.getInt(null), field2.getName());
                    } else if (field2.getName().startsWith("H263Level")) {
                        t.put(field2.getInt(null), field2.getName());
                    } else if (field2.getName().startsWith("H263Profile")) {
                        u.put(field2.getInt(null), field2.getName());
                    } else if (field2.getName().startsWith("MPEG4Level")) {
                        v.put(field2.getInt(null), field2.getName());
                    } else if (field2.getName().startsWith("MPEG4Profile")) {
                        w.put(field2.getInt(null), field2.getName());
                    } else if (field2.getName().startsWith("AAC")) {
                        x.put(field2.getInt(null), field2.getName());
                    }
                }
            }
            o = cls.getField("profile");
            p = cls.getField("level");
        } catch (ClassNotFoundException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (NoSuchFieldException e5) {
        } catch (NoSuchMethodException e6) {
        } catch (SecurityException e7) {
        }
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        if (e != null && g != null) {
            try {
                int intValue = ((Integer) e.getMethod("getCodecCount", new Class[0]).invoke(null, new Object[0])).intValue();
                for (int i2 = 0; i2 < intValue; i2++) {
                    sb.append("\n");
                    Object invoke = f.invoke(null, Integer.valueOf(i2));
                    sb.append(i2).append(": ").append(h.invoke(invoke, new Object[0])).append("\n");
                    sb.append("isEncoder: ").append(i.invoke(invoke, new Object[0])).append("\n");
                    String[] strArr = (String[]) j.invoke(invoke, new Object[0]);
                    sb.append("Supported types: ").append(Arrays.toString(strArr)).append("\n");
                    for (String str : strArr) {
                        sb.append(a(invoke, str));
                    }
                    sb.append("\n");
                }
            } catch (IllegalAccessException e2) {
            } catch (NoSuchMethodException e3) {
            } catch (InvocationTargetException e4) {
            }
        }
        return sb.toString();
    }

    private static String a(Object obj, String str) {
        StringBuilder sb = new StringBuilder();
        Object invoke = k.invoke(obj, str);
        int[] iArr = (int[]) m.get(invoke);
        if (iArr.length > 0) {
            sb.append(str).append(" color formats:");
            for (int i2 = 0; i2 < iArr.length; i2++) {
                sb.append((String) q.get(iArr[i2]));
                if (i2 < iArr.length - 1) {
                    sb.append(',');
                }
            }
            sb.append("\n");
        }
        Object[] objArr = (Object[]) n.get(invoke);
        if (objArr.length > 0) {
            sb.append(str).append(" profile levels:");
            for (int i3 = 0; i3 < objArr.length; i3++) {
                CodecType a2 = a(obj);
                int i4 = o.getInt(objArr[i3]);
                int i5 = p.getInt(objArr[i3]);
                if (a2 == null) {
                    sb.append(i4).append('-').append(i5);
                }
                switch (i.a[a2.ordinal()]) {
                    case 1:
                        sb.append(i4).append((String) s.get(i4)).append('-').append((String) r.get(i5));
                        break;
                    case 2:
                        sb.append((String) u.get(i4)).append('-').append((String) t.get(i5));
                        break;
                    case 3:
                        sb.append((String) w.get(i4)).append('-').append((String) v.get(i5));
                        break;
                    case 4:
                        sb.append((String) x.get(i4));
                        break;
                }
                if (i3 < objArr.length - 1) {
                    sb.append(',');
                }
            }
            sb.append("\n");
        }
        return sb.append("\n").toString();
    }

    private static CodecType a(Object obj) {
        String str = (String) h.invoke(obj, new Object[0]);
        for (String str2 : b) {
            if (str.contains(str2)) {
                return CodecType.AVC;
            }
        }
        for (String str3 : c) {
            if (str.contains(str3)) {
                return CodecType.H263;
            }
        }
        for (String str4 : a) {
            if (str.contains(str4)) {
                return CodecType.MPEG4;
            }
        }
        for (String str5 : d) {
            if (str.contains(str5)) {
                return CodecType.AAC;
            }
        }
        return null;
    }
}
