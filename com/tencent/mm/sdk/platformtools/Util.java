package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.View;
import cn.jingling.lib.file.Shared;
import com.tencent.mm.algorithm.b;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Character;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.Assert;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/* loaded from: classes.dex */
public final class Util {
    public static final int BEGIN_TIME = 22;
    public static final int BIT_OF_KB = 10;
    public static final int BIT_OF_MB = 20;
    public static final int BYTE_OF_KB = 1024;
    public static final int BYTE_OF_MB = 1048576;
    public static final String CHINA = "zh_CN";
    public static final int DAY = 0;
    public static final int END_TIME = 8;
    public static final String ENGLISH = "en";
    public static final String HONGKONG = "zh_HK";
    public static final String LANGUAGE_DEFAULT = "language_default";
    public static final int MASK_16BIT = 65535;
    public static final int MASK_32BIT = -1;
    public static final int MASK_4BIT = 15;
    public static final int MASK_8BIT = 255;
    public static final long MAX_32BIT_VALUE = 4294967295L;
    public static final int MAX_ACCOUNT_LENGTH = 20;
    public static final int MAX_DECODE_PICTURE_SIZE = 2764800;
    public static final int MAX_PASSWORD_LENGTH = 9;
    public static final long MILLSECONDS_OF_DAY = 86400000;
    public static final long MILLSECONDS_OF_HOUR = 3600000;
    public static final long MILLSECONDS_OF_MINUTE = 60000;
    public static final long MILLSECONDS_OF_SECOND = 1000;
    public static final long MINUTE_OF_HOUR = 60;
    public static final int MIN_ACCOUNT_LENGTH = 6;
    public static final int MIN_PASSWORD_LENGTH = 4;
    public static final String PHOTO_DEFAULT_EXT = ".jpg";
    public static final long SECOND_OF_MINUTE = 60;
    public static final String TAIWAN = "zh_TW";
    private static final long[] bt = {300, 200, 300, 200};
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final char[] bu = {'\t', '\n', '\r'};
    private static final char[] bv = {'<', '>', '\"', '\'', '&'};
    private static final String[] bw = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;"};

    private Util() {
    }

    public static String GetHostIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
        } catch (Exception e2) {
        }
        return null;
    }

    public static int UnZipFolder(String str, String str2) {
        try {
            android.util.Log.v("XZip", "UnZipFolder(String, String)");
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return 0;
                }
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                } else {
                    File file = new File(str2 + File.separator + name);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -2;
        }
    }

    private static int a(char[] cArr, int i, int i2) {
        if (i2 <= 0) {
            return 0;
        }
        if (cArr[i] != '#') {
            new String(cArr, i, i2);
            return 0;
        } else if (i2 <= 1 || !(cArr[i + 1] == 'x' || cArr[i + 1] == 'X')) {
            try {
                return Integer.parseInt(new String(cArr, i + 1, i2 - 1), 10);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            try {
                return Integer.parseInt(new String(cArr, i + 2, i2 - 2), 16);
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
    }

    private static void a(Map<String, String> map, String str, Node node, int i) {
        Node item;
        if (node.getNodeName().equals("#text")) {
            map.put(str, node.getNodeValue());
        } else if (node.getNodeName().equals("#cdata-section")) {
            map.put(str, node.getNodeValue());
        } else {
            String str2 = str + "." + node.getNodeName() + (i > 0 ? Integer.valueOf(i) : "");
            map.put(str2, node.getNodeValue());
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null) {
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    map.put(str2 + ".$" + item.getNodeName(), attributes.item(i2).getNodeValue());
                }
            }
            HashMap hashMap = new HashMap();
            NodeList childNodes = node.getChildNodes();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item2 = childNodes.item(i3);
                int nullAsNil = nullAsNil((Integer) hashMap.get(item2.getNodeName()));
                a(map, str2, item2, nullAsNil);
                hashMap.put(item2.getNodeName(), Integer.valueOf(nullAsNil + 1));
            }
        }
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    public static boolean checkPermission(Context context, String str) {
        Assert.assertNotNull(context);
        String packageName = context.getPackageName();
        boolean z = context.getPackageManager().checkPermission(str, packageName) == 0;
        Log.d("MicroMsg.Util", packageName + " has " + (z ? "permission " : "no permission ") + str);
        return z;
    }

    public static boolean checkSDCardFull() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockCount = statFs.getBlockCount();
            long availableBlocks = statFs.getAvailableBlocks();
            if (blockCount <= 0 || blockCount - availableBlocks < 0) {
                return false;
            }
            int i = (int) (((blockCount - availableBlocks) * 100) / blockCount);
            long blockSize = statFs.getBlockSize() * statFs.getFreeBlocks();
            Log.d("MicroMsg.Util", "checkSDCardFull per:" + i + " blockCount:" + blockCount + " availCount:" + availableBlocks + " availSize:" + blockSize);
            return 95 <= i && blockSize <= 52428800;
        }
        return false;
    }

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine + "\n");
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        inputStream.close();
        return sb.toString();
    }

    public static long currentDayInMills() {
        return (nowMilliSecond() / MILLSECONDS_OF_DAY) * MILLSECONDS_OF_DAY;
    }

    public static long currentMonthInMills() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), 1);
        gregorianCalendar2.setTimeZone(GMT);
        return gregorianCalendar2.getTimeInMillis();
    }

    public static long currentTicks() {
        return SystemClock.elapsedRealtime();
    }

    public static long currentWeekInMills() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        gregorianCalendar2.setTimeZone(GMT);
        gregorianCalendar2.add(6, -(gregorianCalendar.get(7) - gregorianCalendar.getFirstDayOfWeek()));
        return gregorianCalendar2.getTimeInMillis();
    }

    public static long currentYearInMills() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(new GregorianCalendar().get(1), 1, 1);
        gregorianCalendar.setTimeZone(GMT);
        return gregorianCalendar.getTimeInMillis();
    }

    public static byte[] decodeHexString(String str) {
        if (str == null || str.length() <= 0) {
            return new byte[0];
        }
        try {
            byte[] bArr = new byte[str.length() / 2];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16) & MASK_8BIT);
            }
            return bArr;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static String dumpArray(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(",");
        }
        return sb.toString();
    }

    public static String dumpHex(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return "(null)";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 3) + (length / 16)];
        for (int i2 = 0; i2 < length; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            cArr2[i] = ' ';
            int i4 = i3 + 1;
            cArr2[i3] = cArr[(b >>> 4) & 15];
            int i5 = i4 + 1;
            cArr2[i4] = cArr[b & 15];
            if (i2 % 16 != 0 || i2 <= 0) {
                i = i5;
            } else {
                i = i5 + 1;
                cArr2[i5] = '\n';
            }
        }
        return new String(cArr2);
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                sb.append(String.format("%02x", Integer.valueOf(bArr[i] & 255)));
            }
        }
        return sb.toString();
    }

    public static String escapeSqlValue(String str) {
        return str != null ? str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "") : str;
    }

    public static String escapeStringForXml(String str) {
        boolean z;
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt >= ' ' || charAt == bu[0] || charAt == bu[1] || charAt == bu[2]) && charAt <= 127) {
                int length2 = bv.length - 1;
                while (true) {
                    if (length2 < 0) {
                        z = true;
                        break;
                    } else if (bv[length2] == charAt) {
                        stringBuffer.append(bw[length2]);
                        z = false;
                        break;
                    } else {
                        length2--;
                    }
                }
                if (z) {
                    stringBuffer.append(charAt);
                }
            } else {
                stringBuffer.append("&#");
                stringBuffer.append(Integer.toString(charAt));
                stringBuffer.append(';');
            }
        }
        return stringBuffer.toString();
    }

    public static String expandEntities(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (i < length) {
            char charAt = str.charAt(i);
            int i4 = i2 + 1;
            cArr[i2] = charAt;
            if (charAt == '&' && i3 == -1) {
                i3 = i4;
            } else if (i3 != -1 && !Character.isLetter(charAt) && !Character.isDigit(charAt) && charAt != '#') {
                if (charAt == ';') {
                    int a2 = a(cArr, i3, (i4 - i3) - 1);
                    if (a2 > 65535) {
                        int i5 = a2 - 65536;
                        cArr[i3 - 1] = (char) ((i5 >> 10) + 55296);
                        cArr[i3] = (char) ((i5 & 1023) + 56320);
                        i3++;
                    } else if (a2 != 0) {
                        cArr[i3 - 1] = (char) a2;
                    } else {
                        i3 = i4;
                    }
                    i4 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                }
            }
            i++;
            i2 = i4;
        }
        return new String(cArr, 0, i2);
    }

    public static String formatSecToMin(int i) {
        return String.format("%d:%02d", Long.valueOf(i / 60), Long.valueOf(i % 60));
    }

    public static String formatUnixTime(long j) {
        return new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new Date(1000 * j));
    }

    public static void freeBitmapMap(Map<String, Bitmap> map) {
        for (Map.Entry<String, Bitmap> entry : map.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null) {
                value.recycle();
            }
        }
        map.clear();
    }

    public static String getCutPasswordMD5(String str) {
        if (str == null) {
            str = "";
        }
        return str.length() <= 16 ? getFullPasswordMD5(str) : getFullPasswordMD5(str.substring(0, 16));
    }

    public static String getDeviceId(Context context) {
        String deviceId;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && (deviceId = telephonyManager.getDeviceId()) != null) {
                return deviceId.trim();
            }
            return null;
        } catch (SecurityException e) {
            Log.e("MicroMsg.Util", "getDeviceId failed, security exception");
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getFullPasswordMD5(String str) {
        return b.a(str.getBytes());
    }

    public static int getHex(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return (int) (Long.decode(str).longValue() & MAX_32BIT_VALUE);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static BitmapFactory.Options getImageOptions(String str) {
        Assert.assertTrue((str == null || str.equals("")) ? false : true);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                decodeFile.recycle();
            }
        } catch (OutOfMemoryError e) {
            Log.e("MicroMsg.Util", "decode bitmap failed: " + e.getMessage());
        }
        return options;
    }

    public static Intent getInstallPackIntent(String str, Context context) {
        Assert.assertTrue((str == null || str.equals("")) ? false : true);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        return intent;
    }

    public static int getInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static int getIntRandom(int i, int i2) {
        Assert.assertTrue(i > i2);
        return new Random(System.currentTimeMillis()).nextInt((i - i2) + 1) + i2;
    }

    public static String getLine1Number(Context context) {
        if (context != null) {
            try {
                if (((TelephonyManager) context.getSystemService("phone")) == null) {
                    Log.e("MicroMsg.Util", "get line1 number failed, null tm");
                }
            } catch (SecurityException e) {
                Log.e("MicroMsg.Util", "getLine1Number failed, security exception");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static long getLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return j;
        }
    }

    public static Element getRootElementFromXML(byte[] bArr) {
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (newDocumentBuilder == null) {
                Log.e("MicroMsg.Util", "new Document Builder failed");
                return null;
            }
            try {
                Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(bArr));
                if (parse == null) {
                    Log.e("MicroMsg.Util", "new Document failed");
                    return null;
                }
                return parse.getDocumentElement();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (SAXException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (ParserConfigurationException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, boolean z, float f) {
        Assert.assertNotNull(bitmap);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-4144960);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static String getSizeKB(long j) {
        if ((j >> 20) > 0) {
            return getSizeMB(j);
        }
        if ((j >> 9) > 0) {
            return (Math.round((((float) j) * 10.0f) / 1024.0f) / 10.0f) + "KB";
        }
        return j + "B";
    }

    public static String getSizeMB(long j) {
        return (Math.round((((float) j) * 10.0f) / 1048576.0f) / 10.0f) + "MB";
    }

    public static String getStack() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 2) {
            return "";
        }
        String str = "";
        for (int i = 1; i < stackTrace.length && stackTrace[i].getClassName().contains(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN); i++) {
            str = str + "[" + stackTrace[i].getClassName().substring(15) + ":" + stackTrace[i].getMethodName() + "]";
        }
        return str;
    }

    public static int getSystemVersion(Context context, int i) {
        return context == null ? i : Settings.System.getInt(context.getContentResolver(), "sys.settings_system_version", i);
    }

    public static String getTimeZone() {
        String timeZoneDef = getTimeZoneDef();
        int indexOf = timeZoneDef.indexOf(43);
        if (indexOf == -1) {
            indexOf = timeZoneDef.indexOf(45);
        }
        if (indexOf == -1) {
            return "";
        }
        String substring = timeZoneDef.substring(indexOf, indexOf + 3);
        return substring.charAt(1) == '0' ? substring.substring(0, 1) + substring.substring(2, 3) : substring;
    }

    public static String getTimeZoneDef() {
        int rawOffset = (int) (TimeZone.getDefault().getRawOffset() / MILLSECONDS_OF_MINUTE);
        char c = '+';
        if (rawOffset < 0) {
            c = '-';
            rawOffset = -rawOffset;
        }
        return String.format("GMT%s%02d:%02d", Character.valueOf(c), Long.valueOf(rawOffset / 60), Long.valueOf(rawOffset % 60));
    }

    public static String getTimeZoneOffset() {
        TimeZone timeZone = TimeZone.getDefault();
        return String.format("%.2f", Double.valueOf((((timeZone.getRawOffset() * 100) / MILLSECONDS_OF_HOUR) / 100.0d) + (timeZone.useDaylightTime() ? 1 : 0)));
    }

    public static String getTopActivityName(Context context) {
        try {
            return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        } catch (Exception e) {
            e.printStackTrace();
            return "(null)";
        }
    }

    public static int guessHttpContinueRecvLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 52 + i;
    }

    public static int guessHttpRecvLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 208 + i;
    }

    public static int guessHttpSendLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 224 + i;
    }

    public static int guessTcpConnectLength() {
        return 172;
    }

    public static int guessTcpDisconnectLength() {
        return 156;
    }

    public static int guessTcpRecvLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 40 + i;
    }

    public static int guessTcpSendLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 40 + i;
    }

    public static void installPack(String str, Context context) {
        context.startActivity(getInstallPackIntent(str, context));
    }

    public static boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean isDayTimeNow() {
        int i = new GregorianCalendar().get(11);
        return ((long) i) >= 6 && ((long) i) < 18;
    }

    public static boolean isImgFile(String str) {
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.Util", "isImgFile, invalid argument");
            return false;
        } else if (str.length() < 3 || !new File(str).exists()) {
            return false;
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return options.outWidth > 0 && options.outHeight > 0;
        }
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean isLockScreen(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isNightTime(int i, int i2, int i3) {
        if (i2 > i3) {
            return i >= i2 || i <= i3;
        } else if (i2 < i3) {
            return i <= i3 && i >= i2;
        } else {
            return true;
        }
    }

    public static boolean isNullOrNil(String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean isNullOrNil(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isProcessRunning(Context context, String str) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(str)) {
                Log.w("MicroMsg.Util", "process " + str + " is running");
                return true;
            }
        }
        Log.w("MicroMsg.Util", "process " + str + " is not running");
        return false;
    }

    public static boolean isServiceRunning(Context context, String str) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Shared.INFINITY)) {
            if (runningServiceInfo != null && runningServiceInfo.service != null && runningServiceInfo.service.getClassName().toString().equals(str)) {
                Log.w("MicroMsg.Util", "service " + str + " is running");
                return true;
            }
        }
        Log.w("MicroMsg.Util", "service " + str + " is not running");
        return false;
    }

    public static boolean isTopActivity(Context context) {
        String name = context.getClass().getName();
        String topActivityName = getTopActivityName(context);
        Log.d("MicroMsg.Util", "top activity=" + topActivityName + ", context=" + name);
        return topActivityName.equalsIgnoreCase(name);
    }

    public static boolean isTopApplication(Context context) {
        try {
            String className = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
            String packageName = context.getPackageName();
            Log.d("MicroMsg.Util", "top activity=" + className + ", context=" + packageName);
            return className.contains(packageName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isValidAccount(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.length() < 6 || trim.length() > 20 || !isAlpha(trim.charAt(0))) {
            return false;
        }
        for (int i = 0; i < trim.length(); i++) {
            char charAt = trim.charAt(i);
            if (!isAlpha(charAt) && !isNum(charAt) && charAt != '-' && charAt != '_') {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmail(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    }

    public static boolean isValidPassword(String str) {
        if (str != null && str.length() >= 4) {
            if (str.length() >= 9) {
                return true;
            }
            try {
                Integer.parseInt(str);
                return false;
            } catch (NumberFormatException e) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidQQNum(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            long longValue = Long.valueOf(str.trim()).longValue();
            return longValue > 0 && longValue <= MAX_32BIT_VALUE;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean jump(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (isIntentAvailable(context, intent)) {
            context.startActivity(intent);
            return true;
        }
        Log.e("MicroMsg.Util", "jump to url failed, " + str);
        return false;
    }

    public static String listToString(List<String> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return sb.toString();
            }
            if (i2 == list.size() - 1) {
                sb.append(list.get(i2).trim());
            } else {
                sb.append(list.get(i2).trim() + str);
            }
            i = i2 + 1;
        }
    }

    public static String mapToXml(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("<key>");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                key = "unknow";
            }
            if (value == null) {
                value = "unknow";
            }
            sb.append("<" + ((Object) key) + ">");
            sb.append((Object) value);
            sb.append("</" + ((Object) key) + ">");
        }
        sb.append("</key>");
        return sb.toString();
    }

    public static long milliSecondsToNow(long j) {
        return System.currentTimeMillis() - j;
    }

    public static long nowMilliSecond() {
        return System.currentTimeMillis();
    }

    public static long nowSecond() {
        return System.currentTimeMillis() / 1000;
    }

    public static int nullAs(Integer num, int i) {
        return num == null ? i : num.intValue();
    }

    public static long nullAs(Long l, long j) {
        return l == null ? j : l.longValue();
    }

    public static String nullAs(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static boolean nullAs(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static boolean nullAsFalse(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static int nullAsInt(Object obj, int i) {
        return obj == null ? i : obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof Long ? ((Long) obj).intValue() : i;
    }

    public static int nullAsNil(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static long nullAsNil(Long l) {
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static boolean nullAsTrue(Boolean bool) {
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static Map<String, String> parseIni(String str) {
        String[] split;
        String[] split2;
        if (str == null || str.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\n")) {
            if (str2 != null && str2.length() > 0 && (split2 = str2.trim().split("=", 2)) != null && split2.length >= 2) {
                String str3 = split2[0];
                String str4 = split2[1];
                if (str3 != null && str3.length() > 0 && str3.matches("^[a-zA-Z0-9_]*")) {
                    hashMap.put(str3, str4);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> parseXml(String str, String str2, String str3) {
        Document document;
        if (str == null || str.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (newDocumentBuilder == null) {
                Log.e("MicroMsg.Util", "new Document Builder failed");
                return null;
            }
            try {
                try {
                    InputSource inputSource = new InputSource(new ByteArrayInputStream(str.getBytes()));
                    if (str3 != null) {
                        inputSource.setEncoding(str3);
                    }
                    document = newDocumentBuilder.parse(inputSource);
                    try {
                        document.normalize();
                    } catch (DOMException e) {
                        e = e;
                        e.printStackTrace();
                        if (document != null) {
                        }
                    }
                } catch (DOMException e2) {
                    e = e2;
                    document = null;
                }
                if (document != null) {
                    Log.e("MicroMsg.Util", "new Document failed");
                    return null;
                }
                Element documentElement = document.getDocumentElement();
                if (documentElement == null) {
                    Log.e("MicroMsg.Util", "getDocumentElement failed");
                    return null;
                }
                if (str2 == null || !str2.equals(documentElement.getNodeName())) {
                    NodeList elementsByTagName = documentElement.getElementsByTagName(str2);
                    if (elementsByTagName.getLength() <= 0) {
                        Log.e("MicroMsg.Util", "parse item null");
                        return null;
                    }
                    if (elementsByTagName.getLength() > 1) {
                        Log.w("MicroMsg.Util", "parse items more than one");
                    }
                    a(hashMap, "", elementsByTagName.item(0), 0);
                } else {
                    a(hashMap, "", documentElement, 0);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    Log.v("MicroMsg.Util", "key=" + ((String) entry.getKey()) + " value=" + ((String) entry.getValue()));
                }
                return hashMap;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            } catch (SAXException e4) {
                e4.printStackTrace();
                return null;
            } catch (Exception e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (ParserConfigurationException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static MediaPlayer playSound(Context context, int i, MediaPlayer.OnCompletionListener onCompletionListener) {
        try {
            AssetFileDescriptor openFd = context.getAssets().openFd(context.getString(i));
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            openFd.close();
            mediaPlayer.prepare();
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(onCompletionListener);
            return mediaPlayer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void playSound(Context context, int i) {
        playSound(context, i, new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mm.sdk.platformtools.Util.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    public static String processXml(String str) {
        return (str == null || str.length() == 0 || Build.VERSION.SDK_INT >= 8) ? str : expandEntities(str);
    }

    public static void saveBitmapToImage(Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat, String str, String str2, boolean z) {
        Assert.assertTrue((str == null || str2 == null) ? false : true);
        Log.d("MicroMsg.Util", "saving to " + str + str2);
        File file = new File(str + str2);
        file.createNewFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0049 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0027 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.Bitmap] */
    public static void saveBitmapToImage(Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat, String str, boolean z) {
        Assert.assertTrue(!isNullOrNil(str));
        ?? r1 = "saving to " + str;
        Log.d("MicroMsg.Util", r1);
        File file = new File(str);
        file.createNewFile();
        try {
            try {
                r1 = new FileOutputStream(file);
                try {
                    bitmap.compress(compressFormat, i, r1);
                    r1.flush();
                    r1.close();
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    r1.close();
                }
            } catch (Throwable th) {
                th = th;
                r1.close();
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            r1 = 0;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            r1.close();
            throw th;
        }
    }

    public static long secondsToNow(long j) {
        return (System.currentTimeMillis() / 1000) - j;
    }

    public static void selectPicture(Context context, int i) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        ((Activity) context).startActivityForResult(Intent.createChooser(intent, null), i);
    }

    public static void shake(Context context, boolean z) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            return;
        }
        if (z) {
            vibrator.vibrate(bt, -1);
        } else {
            vibrator.cancel();
        }
    }

    public static int[] splitToIntArray(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (str2 != null && str2.length() > 0) {
                try {
                    arrayList.add(Integer.valueOf(Integer.valueOf(str2).intValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MicroMsg.Util", "invalid port num, ignore");
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return iArr;
            }
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            i = i2 + 1;
        }
    }

    public static List<String> stringsToList(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static long ticksToNow(long j) {
        return SystemClock.elapsedRealtime() - j;
    }

    public static void transClickToSelect(final View view, final View view2) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mm.sdk.platformtools.Util.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view2.setSelected(true);
                        break;
                    case 1:
                    case 3:
                    case 4:
                        view2.setSelected(false);
                        break;
                    case 2:
                        view2.setSelected(view.isPressed());
                        break;
                }
                return false;
            }
        });
    }
}
