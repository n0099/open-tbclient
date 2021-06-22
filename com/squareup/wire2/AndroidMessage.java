package com.squareup.wire2;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import java.io.IOException;
import java.lang.reflect.Array;
import okio.ByteString;
/* loaded from: classes7.dex */
public abstract class AndroidMessage<M extends Message<M, B>, B extends Message.a<M, B>> extends Message<M, B> implements Parcelable {

    /* loaded from: classes7.dex */
    public static final class a<M> implements Parcelable.Creator<M> {

        /* renamed from: a  reason: collision with root package name */
        public final ProtoAdapter<M> f39532a;

        public a(ProtoAdapter<M> protoAdapter) {
            this.f39532a = protoAdapter;
        }

        @Override // android.os.Parcelable.Creator
        public M createFromParcel(Parcel parcel) {
            try {
                return this.f39532a.decode(parcel.createByteArray());
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // android.os.Parcelable.Creator
        public M[] newArray(int i2) {
            return (M[]) ((Object[]) Array.newInstance(this.f39532a.javaType, i2));
        }
    }

    public AndroidMessage(ProtoAdapter<M> protoAdapter, ByteString byteString) {
        super(protoAdapter, byteString);
    }

    public static <E> Parcelable.Creator<E> newCreator(ProtoAdapter<E> protoAdapter) {
        return new a(protoAdapter);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(encode());
    }
}
