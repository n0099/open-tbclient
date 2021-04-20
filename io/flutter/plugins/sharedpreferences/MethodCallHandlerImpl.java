package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Base64;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    public static final String BIG_INTEGER_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy";
    public static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    public static final String LIST_IDENTIFIER = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    public static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    public final SharedPreferences preferences;

    public MethodCallHandlerImpl(Context context) {
        this.preferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    private void commitAsync(final SharedPreferences.Editor editor, final MethodChannel.Result result) {
        new AsyncTask<Void, Void, Boolean>() { // from class: io.flutter.plugins.sharedpreferences.MethodCallHandlerImpl.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(editor.commit());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            public void onPostExecute(Boolean bool) {
                result.success(bool);
            }
        }.execute(new Void[0]);
    }

    private List<String> decodeList(String str) throws IOException {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (ClassNotFoundException e2) {
            e = e2;
        }
        try {
            List<String> list = (List) objectInputStream.readObject();
            objectInputStream.close();
            return list;
        } catch (ClassNotFoundException e3) {
            e = e3;
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            throw th;
        }
    }

    private String encodeList(List<String> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            objectOutputStream.close();
            return encodeToString;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
            }
            throw th;
        }
    }

    private Map<String, Object> getAllPrefs() throws IOException {
        Object obj;
        Map<String, ?> all = this.preferences.getAll();
        HashMap hashMap = new HashMap();
        for (String str : all.keySet()) {
            if (str.startsWith("flutter.")) {
                Object obj2 = all.get(str);
                if (obj2 instanceof String) {
                    String str2 = (String) obj2;
                    if (str2.startsWith(LIST_IDENTIFIER)) {
                        obj2 = decodeList(str2.substring(40));
                    } else if (str2.startsWith(BIG_INTEGER_PREFIX)) {
                        obj = new BigInteger(str2.substring(44), 36);
                        obj2 = obj;
                    } else if (str2.startsWith(DOUBLE_PREFIX)) {
                        obj2 = Double.valueOf(str2.substring(40));
                    }
                    hashMap.put(str, obj2);
                } else {
                    if (obj2 instanceof Set) {
                        ArrayList arrayList = new ArrayList((Set) obj2);
                        SharedPreferences.Editor remove = this.preferences.edit().remove(str);
                        obj = arrayList;
                        if (!remove.putString(str, LIST_IDENTIFIER + encodeList(arrayList)).commit()) {
                            throw new IOException("Could not migrate set to list");
                        }
                        obj2 = obj;
                    }
                    hashMap.put(str, obj2);
                }
            }
        }
        return hashMap;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("key");
        try {
            String str2 = methodCall.method;
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1354815177:
                    if (str2.equals("commit")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1249367445:
                    if (str2.equals("getAll")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1096934831:
                    if (str2.equals("setStringList")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -934610812:
                    if (str2.equals("remove")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -905809875:
                    if (str2.equals("setInt")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 155439827:
                    if (str2.equals("setDouble")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 589412115:
                    if (str2.equals("setString")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1984457324:
                    if (str2.equals("setBool")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    commitAsync(this.preferences.edit().putBoolean(str, ((Boolean) methodCall.argument("value")).booleanValue()), result);
                    return;
                case 1:
                    String d2 = Double.toString(((Number) methodCall.argument("value")).doubleValue());
                    SharedPreferences.Editor edit = this.preferences.edit();
                    commitAsync(edit.putString(str, DOUBLE_PREFIX + d2), result);
                    return;
                case 2:
                    Number number = (Number) methodCall.argument("value");
                    if (number instanceof BigInteger) {
                        SharedPreferences.Editor edit2 = this.preferences.edit();
                        commitAsync(edit2.putString(str, BIG_INTEGER_PREFIX + ((BigInteger) number).toString(36)), result);
                        return;
                    }
                    commitAsync(this.preferences.edit().putLong(str, number.longValue()), result);
                    return;
                case 3:
                    String str3 = (String) methodCall.argument("value");
                    if (!str3.startsWith(LIST_IDENTIFIER) && !str3.startsWith(BIG_INTEGER_PREFIX)) {
                        commitAsync(this.preferences.edit().putString(str, str3), result);
                        return;
                    }
                    result.error("StorageError", "This string cannot be stored as it clashes with special identifier prefixes.", null);
                    return;
                case 4:
                    SharedPreferences.Editor edit3 = this.preferences.edit();
                    commitAsync(edit3.putString(str, LIST_IDENTIFIER + encodeList((List) methodCall.argument("value"))), result);
                    return;
                case 5:
                    result.success(Boolean.TRUE);
                    return;
                case 6:
                    result.success(getAllPrefs());
                    return;
                case 7:
                    commitAsync(this.preferences.edit().remove(str), result);
                    return;
                case '\b':
                    Set<String> keySet = getAllPrefs().keySet();
                    SharedPreferences.Editor edit4 = this.preferences.edit();
                    for (String str4 : keySet) {
                        edit4.remove(str4);
                    }
                    commitAsync(edit4, result);
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        } catch (IOException e2) {
            result.error("IOException encountered", methodCall.method, e2);
        }
    }
}
