package com.kuaishou.weapon.un;

import android.content.pm.ActivityInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final long f55148b = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<m> a;

    public l(ActivityInfo[] activityInfoArr) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activityInfoArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        if (activityInfoArr == null || (length = activityInfoArr.length) <= 0) {
            return;
        }
        this.a = new ArrayList<>(length);
        for (int i4 = 0; i4 < length; i4++) {
            if (activityInfoArr[i4] != null) {
                m mVar = new m();
                mVar.f55159h = activityInfoArr[i4].configChanges;
                mVar.f55157f = activityInfoArr[i4].flags;
                mVar.m = activityInfoArr[i4].labelRes;
                mVar.f55153b = activityInfoArr[i4].launchMode;
                if (activityInfoArr[i4].nonLocalizedLabel != null) {
                    mVar.n = activityInfoArr[i4].nonLocalizedLabel.toString();
                }
                mVar.k = activityInfoArr[i4].name;
                mVar.l = activityInfoArr[i4].packageName;
                mVar.f55154c = activityInfoArr[i4].permission;
                mVar.f55158g = activityInfoArr[i4].screenOrientation;
                mVar.f55160i = activityInfoArr[i4].softInputMode;
                mVar.f55156e = activityInfoArr[i4].targetActivity;
                mVar.f55155d = activityInfoArr[i4].taskAffinity;
                mVar.a = activityInfoArr[i4].theme;
                this.a.add(mVar);
            }
        }
    }

    public static ArrayList<m> a(byte[] bArr) {
        InterceptResult invokeL;
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, bArr)) != null) {
            return (ArrayList) invokeL.objValue;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    ArrayList<m> arrayList = (ArrayList) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e2) {
                        l1.a(e2);
                    }
                    return arrayList;
                } catch (Throwable unused) {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e3) {
                            l1.a(e3);
                            return null;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    return null;
                }
            } catch (Throwable unused2) {
                objectInputStream = null;
            }
        } catch (Throwable unused3) {
            objectInputStream = null;
            byteArrayInputStream = null;
        }
    }

    public byte[] a() {
        InterceptResult invokeV;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (IOException unused) {
                    objectOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused2) {
                byteArrayOutputStream = null;
                objectOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(this.a);
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    l1.a(e2);
                }
                return byteArray;
            } catch (IOException unused3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                        l1.a(e3);
                        return null;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e4) {
                        l1.a(e4);
                        throw th;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return (byte[]) invokeV.objValue;
    }
}
