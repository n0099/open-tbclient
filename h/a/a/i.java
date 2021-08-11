package h.a.a;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f78053a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f78054b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f78055c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f78056d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f78057e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f78058f;

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f78059g;

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f78060h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1772533215, "Lh/a/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1772533215, "Lh/a/a/i;");
                return;
            }
        }
        f78053a = new int[]{1, 5, 9, 13, 17, 25, 33, 41, 49, 65, 81, 97, 113, 145, Opcodes.RETURN, 209, BaseActivity.DIALOG_PROMPT, 305, SDKLogTypeConstants.TYPE_APO_SUCCESS, 497, 753, 1265, 2289, 4337, 8433, 16625};
        f78054b = new int[]{2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 24};
        f78055c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, 10, 14, 18, 26, 34, 50, 66, 98, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 194, 322, 578, 1090, 2114, 6210, 22594};
        f78056d = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24};
        f78057e = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 18, 22, 30, 38, 54, 70, 102, 134, Opcodes.IFNULL, 326, 582, 1094, 2118};
        f78058f = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24};
        f78059g = new int[]{0, 0, 8, 8, 0, 16, 8, 16, 16};
        f78060h = new int[]{0, 8, 0, 8, 16, 0, 16, 8, 16};
    }
}
