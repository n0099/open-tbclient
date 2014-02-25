package protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import protobuf.Im;
/* loaded from: classes.dex */
public final class z extends GeneratedMessageLite.Builder<Im.Photo, z> implements aa {
    private int a;
    private Object b = "";
    private Object c = "";
    private Object d = "";

    private z() {
        g();
    }

    private void g() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [protobuf.Im.Photo.newBuilder():protobuf.z] */
    public static /* synthetic */ z f() {
        return h();
    }

    public static z h() {
        return new z();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    public z clear() {
        super.clear();
        this.b = "";
        this.a &= -2;
        this.c = "";
        this.a &= -3;
        this.d = "";
        this.a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: b */
    public z clone() {
        return h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c */
    public Im.Photo getDefaultInstanceForType() {
        return Im.Photo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d */
    public Im.Photo build() {
        Im.Photo buildPartial = buildPartial();
        if (!buildPartial.isInitialized()) {
            throw newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e */
    public Im.Photo buildPartial() {
        Im.Photo photo = new Im.Photo(this, (Im.Photo) null);
        int i = this.a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        photo.smallurl_ = this.b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        photo.bigurl_ = this.c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        photo.picId_ = this.d;
        photo.bitField0_ = i2;
        return photo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a */
    public z mergeFrom(Im.Photo photo) {
        Object obj;
        Object obj2;
        Object obj3;
        if (photo != Im.Photo.getDefaultInstance()) {
            if (photo.hasSmallurl()) {
                this.a |= 1;
                obj3 = photo.smallurl_;
                this.b = obj3;
            }
            if (photo.hasBigurl()) {
                this.a |= 2;
                obj2 = photo.bigurl_;
                this.c = obj2;
            }
            if (photo.hasPicId()) {
                this.a |= 4;
                obj = photo.picId_;
                this.d = obj;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x001e  */
    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public z mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Im.Photo photo;
        Throwable th;
        try {
            try {
                Im.Photo parsePartialFrom = Im.Photo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                if (parsePartialFrom != null) {
                    mergeFrom(parsePartialFrom);
                }
                return this;
            } catch (Throwable th2) {
                th = th2;
                photo = null;
                if (photo != null) {
                    mergeFrom(photo);
                }
                throw th;
            }
        } catch (InvalidProtocolBufferException e) {
            Im.Photo photo2 = (Im.Photo) e.getUnfinishedMessage();
            try {
                throw e;
            } catch (Throwable th3) {
                photo = photo2;
                th = th3;
                if (photo != null) {
                }
                throw th;
            }
        }
    }
}
