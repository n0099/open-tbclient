package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BIG_INTEGER_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy";
    public static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
    public static final String LIST_IDENTIFIER = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
    public static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPreferences preferences;

    public MethodCallHandlerImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.preferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    private void commitAsync(SharedPreferences.Editor editor, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, editor, result) == null) {
            new AsyncTask<Void, Void, Boolean>(this, editor, result) { // from class: io.flutter.plugins.sharedpreferences.MethodCallHandlerImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MethodCallHandlerImpl this$0;
                public final /* synthetic */ SharedPreferences.Editor val$editor;
                public final /* synthetic */ MethodChannel.Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, editor, result};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$editor = editor;
                    this.val$result = result;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, voidArr)) == null) ? Boolean.valueOf(this.val$editor.commit()) : (Boolean) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public void onPostExecute(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                        this.val$result.success(bool);
                    }
                }
            }.execute(new Void[0]);
        }
    }

    private List<String> decodeList(String str) throws IOException {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            ObjectInputStream objectInputStream2 = null;
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
                } catch (ClassNotFoundException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                List<String> list = (List) objectInputStream.readObject();
                objectInputStream.close();
                return list;
            } catch (ClassNotFoundException e3) {
                e = e3;
                objectInputStream2 = objectInputStream;
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
        return (List) invokeL.objValue;
    }

    private String encodeList(List<String> list) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, list)) != null) {
            return (String) invokeL.objValue;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeObject(list);
                objectOutputStream2.flush();
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                objectOutputStream2.close();
                return encodeToString;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private Map<String, Object> getAllPrefs() throws IOException {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
        return (Map) invokeV.objValue;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, methodCall, result) == null) {
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
}
