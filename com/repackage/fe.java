package com.repackage;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes6.dex */
public class fe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final mc a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new hc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new wc((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new fc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new vc((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new oc((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new sc((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new qc((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new tc((Set) obj);
                                            }
                                            if (cc.e(cls, OrmObject.class)) {
                                                return new rc((OrmObject) obj);
                                            }
                                            return null;
                                        }
                                        return new uc(((Short) obj).shortValue());
                                    }
                                    return new pc(((Long) obj).longValue());
                                }
                                return new nc(((Integer) obj).intValue());
                            }
                            return new lc(((Float) obj).floatValue());
                        }
                        return new kc(((Double) obj).doubleValue());
                    }
                    return new jc(((Character) obj).charValue());
                }
                return new ic(((Byte) obj).byteValue());
            }
            return new gc(((Boolean) obj).booleanValue());
        }
        return (mc) invokeL.objValue;
    }
}
