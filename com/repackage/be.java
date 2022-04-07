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
/* loaded from: classes5.dex */
public class be {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ic a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new dc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new sc((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new bc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new rc((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new kc((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new oc((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new mc((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new pc((Set) obj);
                                            }
                                            if (yb.e(cls, OrmObject.class)) {
                                                return new nc((OrmObject) obj);
                                            }
                                            return null;
                                        }
                                        return new qc(((Short) obj).shortValue());
                                    }
                                    return new lc(((Long) obj).longValue());
                                }
                                return new jc(((Integer) obj).intValue());
                            }
                            return new hc(((Float) obj).floatValue());
                        }
                        return new gc(((Double) obj).doubleValue());
                    }
                    return new fc(((Character) obj).charValue());
                }
                return new ec(((Byte) obj).byteValue());
            }
            return new cc(((Boolean) obj).booleanValue());
        }
        return (ic) invokeL.objValue;
    }
}
