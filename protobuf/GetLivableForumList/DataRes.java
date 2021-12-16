package protobuf.GetLivableForumList;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.ForumRalatedInfo;
/* loaded from: classes4.dex */
public final class DataRes extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_AVAILABLE;
    public static final Integer DEFAULT_HASMORE;
    public static final List<ForumRalatedInfo> DEFAULT_LIKELIST;
    public static final Integer DEFAULT_MINLEVEL;
    public static final String DEFAULT_TIPS = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer available;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(label = Message.Label.REPEATED, tag = 4)
    public final List<ForumRalatedInfo> likeList;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer minLevel;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String tips;

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer available;
        public Integer hasMore;
        public List<ForumRalatedInfo> likeList;
        public Integer minLevel;
        public String tips;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(DataRes dataRes) {
            super(dataRes);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dataRes};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (dataRes == null) {
                return;
            }
            this.available = dataRes.available;
            this.minLevel = dataRes.minLevel;
            this.tips = dataRes.tips;
            this.likeList = Message.copyOf(dataRes.likeList);
            this.hasMore = dataRes.hasMore;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DataRes(this, z, null) : (DataRes) invokeZ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-161525078, "Lprotobuf/GetLivableForumList/DataRes;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-161525078, "Lprotobuf/GetLivableForumList/DataRes;");
                return;
            }
        }
        DEFAULT_AVAILABLE = 0;
        DEFAULT_MINLEVEL = 0;
        DEFAULT_LIKELIST = Collections.emptyList();
        DEFAULT_HASMORE = 0;
    }

    public /* synthetic */ DataRes(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataRes(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            Integer num = builder.available;
            if (num == null) {
                this.available = DEFAULT_AVAILABLE;
            } else {
                this.available = num;
            }
            Integer num2 = builder.minLevel;
            if (num2 == null) {
                this.minLevel = DEFAULT_MINLEVEL;
            } else {
                this.minLevel = num2;
            }
            String str = builder.tips;
            if (str == null) {
                this.tips = "";
            } else {
                this.tips = str;
            }
            List<ForumRalatedInfo> list = builder.likeList;
            if (list == null) {
                this.likeList = DEFAULT_LIKELIST;
            } else {
                this.likeList = Message.immutableCopyOf(list);
            }
            Integer num3 = builder.hasMore;
            if (num3 == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = num3;
                return;
            }
        }
        this.available = builder.available;
        this.minLevel = builder.minLevel;
        this.tips = builder.tips;
        this.likeList = Message.immutableCopyOf(builder.likeList);
        this.hasMore = builder.hasMore;
    }
}
