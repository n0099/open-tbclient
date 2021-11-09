package com.squareup.wire2;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import java.io.IOException;
import java.lang.reflect.Array;
import okio.ByteString;
/* loaded from: classes2.dex */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.a<M, B>> extends Message<M, B> implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a<M> implements Parcelable.Creator<M> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ProtoAdapter<M> f68293a;

        public a(ProtoAdapter<M> protoAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {protoAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68293a = protoAdapter;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                try {
                    return this.f68293a.decode(parcel.createByteArray());
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
            return (M) invokeL.objValue;
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (M[]) ((Object[]) Array.newInstance(this.f68293a.javaType, i2)) : (M[]) ((Object[]) invokeI.objValue);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidMessage(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        super(protoAdapter, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {protoAdapter, byteString};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> protoAdapter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, protoAdapter)) == null) ? new a(protoAdapter) : (Parcelable.Creator) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
            parcel.writeByteArray(encode());
        }
    }
}
