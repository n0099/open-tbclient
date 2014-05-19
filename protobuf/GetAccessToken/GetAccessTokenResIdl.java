package protobuf.GetAccessToken;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class GetAccessTokenResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ GetAccessTokenResIdl(Builder builder, boolean z, GetAccessTokenResIdl getAccessTokenResIdl) {
        this(builder, z);
    }

    private GetAccessTokenResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GetAccessTokenResIdl> {
        public DataRes data;
        public Error error;

        public Builder(GetAccessTokenResIdl getAccessTokenResIdl) {
            super(getAccessTokenResIdl);
            if (getAccessTokenResIdl != null) {
                this.error = getAccessTokenResIdl.error;
                this.data = getAccessTokenResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetAccessTokenResIdl build(boolean z) {
            return new GetAccessTokenResIdl(this, z, null);
        }
    }
}
