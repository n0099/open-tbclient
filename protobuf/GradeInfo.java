package protobuf;

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
/* loaded from: classes5.dex */
public final class GradeInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_GRADE;
    public static final String DEFAULT_INTRO = "";
    public static final Integer DEFAULT_MAXMEMBERNUM;
    public static final Integer DEFAULT_THRESHOLDDAY;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer grade;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer maxMemberNum;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer thresholdDay;

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<GradeInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer grade;
        public String intro;
        public Integer maxMemberNum;
        public Integer thresholdDay;

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
        public Builder(GradeInfo gradeInfo) {
            super(gradeInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gradeInfo};
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
            if (gradeInfo == null) {
                return;
            }
            this.grade = gradeInfo.grade;
            this.intro = gradeInfo.intro;
            this.thresholdDay = gradeInfo.thresholdDay;
            this.maxMemberNum = gradeInfo.maxMemberNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GradeInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new GradeInfo(this, z, null) : (GradeInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-894926578, "Lprotobuf/GradeInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-894926578, "Lprotobuf/GradeInfo;");
                return;
            }
        }
        DEFAULT_GRADE = 0;
        DEFAULT_THRESHOLDDAY = 0;
        DEFAULT_MAXMEMBERNUM = 0;
    }

    public /* synthetic */ GradeInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradeInfo(Builder builder, boolean z) {
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
            Integer num = builder.grade;
            if (num == null) {
                this.grade = DEFAULT_GRADE;
            } else {
                this.grade = num;
            }
            String str = builder.intro;
            if (str == null) {
                this.intro = "";
            } else {
                this.intro = str;
            }
            Integer num2 = builder.thresholdDay;
            if (num2 == null) {
                this.thresholdDay = DEFAULT_THRESHOLDDAY;
            } else {
                this.thresholdDay = num2;
            }
            Integer num3 = builder.maxMemberNum;
            if (num3 == null) {
                this.maxMemberNum = DEFAULT_MAXMEMBERNUM;
                return;
            } else {
                this.maxMemberNum = num3;
                return;
            }
        }
        this.grade = builder.grade;
        this.intro = builder.intro;
        this.thresholdDay = builder.thresholdDay;
        this.maxMemberNum = builder.maxMemberNum;
    }
}
