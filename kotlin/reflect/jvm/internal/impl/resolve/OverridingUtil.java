package kotlin.reflect.jvm.internal.impl.resolve;

import com.baidu.down.request.task.ProgressInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
/* loaded from: classes9.dex */
public class OverridingUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final OverridingUtil DEFAULT;
    public static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY;
    public static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = CollectionsKt___CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    public final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    public final KotlinTypeRefiner kotlinTypeRefiner;

    /* JADX WARN: Removed duplicated region for block: B:105:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0242 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0057 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0162 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Object[] objArr;
        if (i != 7 && i != 8 && i != 12 && i != 17 && i != 90 && i != 93 && i != 98 && i != 40 && i != 41) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 85:
                                        case 86:
                                        case 87:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 75:
                                case 76:
                                case 77:
                                case 78:
                                case 79:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                            break;
                    }
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    break;
            }
            if (i != 7 && i != 8 && i != 12 && i != 17 && i != 90 && i != 93 && i != 98 && i != 40 && i != 41) {
                switch (i) {
                    default:
                        switch (i) {
                            default:
                                switch (i) {
                                    default:
                                        switch (i) {
                                            case 85:
                                            case 86:
                                            case 87:
                                                break;
                                            default:
                                                i2 = 3;
                                                break;
                                        }
                                    case 75:
                                    case 76:
                                    case 77:
                                    case 78:
                                    case 79:
                                        i2 = 2;
                                        break;
                                }
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                                break;
                        }
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        break;
                }
                objArr = new Object[i2];
                switch (i) {
                    case 1:
                    case 3:
                        objArr[0] = "kotlinTypeRefiner";
                        break;
                    case 2:
                        objArr[0] = "axioms";
                        break;
                    case 4:
                    case 5:
                        objArr[0] = "candidateSet";
                        break;
                    case 6:
                        objArr[0] = "transformFirst";
                        break;
                    case 7:
                    case 8:
                    case 12:
                    case 17:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 40:
                    case 41:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 85:
                    case 86:
                    case 87:
                    case 90:
                    case 93:
                    case 98:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                        break;
                    case 9:
                        objArr[0] = "f";
                        break;
                    case 10:
                        objArr[0] = "g";
                        break;
                    case 11:
                    case 13:
                        objArr[0] = "descriptor";
                        break;
                    case 14:
                        objArr[0] = "result";
                        break;
                    case 15:
                    case 18:
                    case 26:
                    case 36:
                        objArr[0] = "superDescriptor";
                        break;
                    case 16:
                    case 19:
                    case 27:
                    case 37:
                        objArr[0] = "subDescriptor";
                        break;
                    case 38:
                        objArr[0] = "firstParameters";
                        break;
                    case 39:
                        objArr[0] = "secondParameters";
                        break;
                    case 42:
                        objArr[0] = "typeInSuper";
                        break;
                    case 43:
                        objArr[0] = "typeInSub";
                        break;
                    case 44:
                    case 47:
                        objArr[0] = "typeChecker";
                        break;
                    case 45:
                        objArr[0] = "superTypeParameter";
                        break;
                    case 46:
                        objArr[0] = "subTypeParameter";
                        break;
                    case 48:
                        objArr[0] = "name";
                        break;
                    case 49:
                        objArr[0] = "membersFromSupertypes";
                        break;
                    case 50:
                        objArr[0] = "membersFromCurrent";
                        break;
                    case 51:
                    case 57:
                    case 60:
                    case 81:
                    case 84:
                    case 91:
                        objArr[0] = ProgressInfo.JSON_KEY_CURRENT;
                        break;
                    case 52:
                    case 58:
                    case 62:
                    case 82:
                    case 101:
                        objArr[0] = "strategy";
                        break;
                    case 53:
                        objArr[0] = "overriding";
                        break;
                    case 54:
                        objArr[0] = "fromSuper";
                        break;
                    case 55:
                        objArr[0] = "fromCurrent";
                        break;
                    case 56:
                        objArr[0] = "descriptorsFromSuper";
                        break;
                    case 59:
                    case 61:
                        objArr[0] = "notOverridden";
                        break;
                    case 63:
                    case 65:
                    case 69:
                        objArr[0] = "a";
                        break;
                    case 64:
                    case 66:
                    case 71:
                        objArr[0] = "b";
                        break;
                    case 67:
                        objArr[0] = "candidate";
                        break;
                    case 68:
                    case 83:
                    case 88:
                    case 104:
                        objArr[0] = "descriptors";
                        break;
                    case 70:
                        objArr[0] = "aReturnType";
                        break;
                    case 72:
                        objArr[0] = "bReturnType";
                        break;
                    case 73:
                    case 80:
                        objArr[0] = "overridables";
                        break;
                    case 74:
                    case 96:
                        objArr[0] = "descriptorByHandle";
                        break;
                    case 89:
                        objArr[0] = "classModality";
                        break;
                    case 92:
                        objArr[0] = "toFilter";
                        break;
                    case 94:
                    case 99:
                        objArr[0] = "overrider";
                        break;
                    case 95:
                    case 100:
                        objArr[0] = "extractFrom";
                        break;
                    case 97:
                        objArr[0] = "onConflict";
                        break;
                    case 102:
                    case 103:
                        objArr[0] = "memberDescriptor";
                        break;
                    default:
                        objArr[0] = "equalityAxioms";
                        break;
                }
                if (i != 7 || i == 8) {
                    objArr[1] = "filterOverrides";
                } else if (i != 12) {
                    if (i != 17) {
                        if (i == 90) {
                            objArr[1] = "getMinimalModality";
                        } else if (i == 93) {
                            objArr[1] = "filterVisibleFakeOverrides";
                        } else if (i == 98) {
                            objArr[1] = "extractMembersOverridableInBothWays";
                        } else if (i != 40 && i != 41) {
                            switch (i) {
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                    break;
                                default:
                                    switch (i) {
                                        case 28:
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                            objArr[1] = "isOverridableByWithoutExternalConditions";
                                            break;
                                        default:
                                            switch (i) {
                                                case 75:
                                                case 76:
                                                case 77:
                                                case 78:
                                                case 79:
                                                    objArr[1] = "selectMostSpecificMember";
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 85:
                                                        case 86:
                                                        case 87:
                                                            objArr[1] = "determineModalityForFakeOverride";
                                                            break;
                                                        default:
                                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                                            break;
                                                    }
                                            }
                                    }
                            }
                        } else {
                            objArr[1] = "createTypeChecker";
                        }
                    }
                    objArr[1] = "isOverridableBy";
                } else {
                    objArr[1] = "getOverriddenDeclarations";
                }
                switch (i) {
                    case 1:
                        objArr[2] = "createWithTypeRefiner";
                        break;
                    case 2:
                    case 3:
                        objArr[2] = "<init>";
                        break;
                    case 4:
                        objArr[2] = "filterOutOverridden";
                        break;
                    case 5:
                    case 6:
                        objArr[2] = "filterOverrides";
                        break;
                    case 7:
                    case 8:
                    case 12:
                    case 17:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 40:
                    case 41:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 85:
                    case 86:
                    case 87:
                    case 90:
                    case 93:
                    case 98:
                        break;
                    case 9:
                    case 10:
                        objArr[2] = "overrides";
                        break;
                    case 11:
                        objArr[2] = "getOverriddenDeclarations";
                        break;
                    case 13:
                    case 14:
                        objArr[2] = "collectOverriddenDeclarations";
                        break;
                    case 15:
                    case 16:
                    case 18:
                    case 19:
                        objArr[2] = "isOverridableBy";
                        break;
                    case 26:
                    case 27:
                        objArr[2] = "isOverridableByWithoutExternalConditions";
                        break;
                    case 36:
                    case 37:
                        objArr[2] = "getBasicOverridabilityProblem";
                        break;
                    case 38:
                    case 39:
                        objArr[2] = "createTypeChecker";
                        break;
                    case 42:
                    case 43:
                    case 44:
                        objArr[2] = "areTypesEquivalent";
                        break;
                    case 45:
                    case 46:
                    case 47:
                        objArr[2] = "areTypeParametersEquivalent";
                        break;
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                        objArr[2] = "generateOverridesInFunctionGroup";
                        break;
                    case 53:
                    case 54:
                        objArr[2] = "isVisibleForOverride";
                        break;
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        objArr[2] = "extractAndBindOverridesForMember";
                        break;
                    case 59:
                        objArr[2] = "allHasSameContainingDeclaration";
                        break;
                    case 60:
                    case 61:
                    case 62:
                        objArr[2] = "createAndBindFakeOverrides";
                        break;
                    case 63:
                    case 64:
                        objArr[2] = "isMoreSpecific";
                        break;
                    case 65:
                    case 66:
                        objArr[2] = "isVisibilityMoreSpecific";
                        break;
                    case 67:
                    case 68:
                        objArr[2] = "isMoreSpecificThenAllOf";
                        break;
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                        objArr[2] = "isReturnTypeMoreSpecific";
                        break;
                    case 73:
                    case 74:
                        objArr[2] = "selectMostSpecificMember";
                        break;
                    case 80:
                    case 81:
                    case 82:
                        objArr[2] = "createAndBindFakeOverride";
                        break;
                    case 83:
                    case 84:
                        objArr[2] = "determineModalityForFakeOverride";
                        break;
                    case 88:
                    case 89:
                        objArr[2] = "getMinimalModality";
                        break;
                    case 91:
                    case 92:
                        objArr[2] = "filterVisibleFakeOverrides";
                        break;
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 99:
                    case 100:
                    case 101:
                        objArr[2] = "extractMembersOverridableInBothWays";
                        break;
                    case 102:
                        objArr[2] = "resolveUnknownVisibilityForMember";
                        break;
                    case 103:
                        objArr[2] = "computeVisibilityToInherit";
                        break;
                    case 104:
                        objArr[2] = "findMaxVisibility";
                        break;
                    default:
                        objArr[2] = "createWithEqualityAxioms";
                        break;
                }
                String format = String.format(str, objArr);
                if (i != 7 && i != 8 && i != 12 && i != 17 && i != 90 && i != 93 && i != 98 && i != 40 && i != 41) {
                    switch (i) {
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                        default:
                            switch (i) {
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                    break;
                                default:
                                    switch (i) {
                                        case 75:
                                        case 76:
                                        case 77:
                                        case 78:
                                        case 79:
                                            break;
                                        default:
                                            switch (i) {
                                                case 85:
                                                case 86:
                                                case 87:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                    }
                            }
                    }
                }
                throw new IllegalStateException(format);
            }
            i2 = 2;
            objArr = new Object[i2];
            switch (i) {
            }
            if (i != 7) {
            }
            objArr[1] = "filterOverrides";
            switch (i) {
            }
            String format2 = String.format(str, objArr);
            if (i != 7) {
                switch (i) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i != 7) {
            switch (i) {
            }
            objArr = new Object[i2];
            switch (i) {
            }
            if (i != 7) {
            }
            objArr[1] = "filterOverrides";
            switch (i) {
            }
            String format22 = String.format(str, objArr);
            if (i != 7) {
            }
            throw new IllegalStateException(format22);
        }
        i2 = 2;
        objArr = new Object[i2];
        switch (i) {
        }
        if (i != 7) {
        }
        objArr[1] = "filterOverrides";
        switch (i) {
        }
        String format222 = String.format(str, objArr);
        if (i != 7) {
        }
        throw new IllegalStateException(format222);
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$9  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$descriptors$Modality;
        public static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result;
        public static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result;

        static {
            int[] iArr = new int[Modality.values().length];
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = iArr2;
            try {
                iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = iArr3;
            try {
                iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class OverrideCompatibilityInfo {
        public static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        public final String debugMessage;
        public final Result overridable;

        /* loaded from: classes9.dex */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String format;
            String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 3 : 2];
            if (i != 1 && i != 2) {
                if (i == 3) {
                    objArr[0] = "success";
                } else if (i != 4) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                }
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                        break;
                    case 5:
                        objArr[1] = "getResult";
                        break;
                    case 6:
                        objArr[1] = "getDebugMessage";
                        break;
                    default:
                        objArr[1] = "success";
                        break;
                }
                if (i != 1) {
                    objArr[2] = "incompatible";
                } else if (i == 2) {
                    objArr[2] = "conflict";
                } else if (i == 3 || i == 4) {
                    objArr[2] = "<init>";
                }
                format = String.format(str, objArr);
                if (i == 1 && i != 2 && i != 3 && i != 4) {
                    throw new IllegalStateException(format);
                }
                throw new IllegalArgumentException(format);
            }
            objArr[0] = "debugMessage";
            switch (i) {
            }
            if (i != 1) {
            }
            format = String.format(str, objArr);
            if (i == 1) {
            }
            throw new IllegalArgumentException(format);
        }

        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = SUCCESS;
            if (overrideCompatibilityInfo == null) {
                $$$reportNull$$$0(0);
            }
            return overrideCompatibilityInfo;
        }

        public Result getResult() {
            Result result = this.overridable;
            if (result == null) {
                $$$reportNull$$$0(5);
            }
            return result;
        }

        public OverrideCompatibilityInfo(Result result, String str) {
            if (result == null) {
                $$$reportNull$$$0(3);
            }
            if (str == null) {
                $$$reportNull$$$0(4);
            }
            this.overridable = result;
            this.debugMessage = str;
        }

        public static OverrideCompatibilityInfo conflict(String str) {
            if (str == null) {
                $$$reportNull$$$0(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        public static OverrideCompatibilityInfo incompatible(String str) {
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }
    }

    static {
        KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality = new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.1
            public static /* synthetic */ void $$$reportNull$$$0(int i) {
                Object[] objArr = new Object[3];
                if (i != 1) {
                    objArr[0] = "a";
                } else {
                    objArr[0] = "b";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
                objArr[2] = "equals";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
            public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                }
                if (typeConstructor2 == null) {
                    $$$reportNull$$$0(1);
                }
                return typeConstructor.equals(typeConstructor2);
            }
        };
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = typeConstructorEquality;
        DEFAULT = new OverridingUtil(typeConstructorEquality, KotlinTypeRefiner.Default.INSTANCE);
    }

    public OverridingUtil(KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(2);
        }
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(3);
        }
        this.equalityAxioms = typeConstructorEquality;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
    }

    public static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(final ClassDescriptor classDescriptor, Collection<CallableMemberDescriptor> collection) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(91);
        }
        if (collection == null) {
            $$$reportNull$$$0(92);
        }
        List filter = CollectionsKt___CollectionsKt.filter(collection, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                boolean z;
                if (!Visibilities.isPrivate(callableMemberDescriptor.getVisibility()) && Visibilities.isVisibleIgnoringReceiver(callableMemberDescriptor, ClassDescriptor.this)) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        if (filter == null) {
            $$$reportNull$$$0(93);
        }
        return filter;
    }

    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverrideCompatibilityInfo.Result result = DEFAULT.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        OverrideCompatibilityInfo.Result result2 = DEFAULT.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        OverrideCompatibilityInfo.Result result3 = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (result != result3 || result2 != result3) {
            OverrideCompatibilityInfo.Result result4 = OverrideCompatibilityInfo.Result.CONFLICT;
            if (result != result4 && result2 != result4) {
                return OverrideCompatibilityInfo.Result.INCOMPATIBLE;
            }
            return OverrideCompatibilityInfo.Result.CONFLICT;
        }
        return result3;
    }

    public static boolean isAccessorMoreSpecific(PropertyAccessorDescriptor propertyAccessorDescriptor, PropertyAccessorDescriptor propertyAccessorDescriptor2) {
        if (propertyAccessorDescriptor != null && propertyAccessorDescriptor2 != null) {
            return isVisibilityMoreSpecific(propertyAccessorDescriptor, propertyAccessorDescriptor2);
        }
        return true;
    }

    public static boolean isMoreSpecificThenAllOf(CallableDescriptor callableDescriptor, Collection<CallableDescriptor> collection) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(67);
        }
        if (collection == null) {
            $$$reportNull$$$0(68);
        }
        for (CallableDescriptor callableDescriptor2 : collection) {
            if (!isMoreSpecific(callableDescriptor, callableDescriptor2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isVisibilityMoreSpecific(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(65);
        }
        if (declarationDescriptorWithVisibility2 == null) {
            $$$reportNull$$$0(66);
        }
        Integer compare = Visibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        if (compare != null && compare.intValue() < 0) {
            return false;
        }
        return true;
    }

    public static boolean isVisibleForOverride(MemberDescriptor memberDescriptor, MemberDescriptor memberDescriptor2) {
        if (memberDescriptor == null) {
            $$$reportNull$$$0(53);
        }
        if (memberDescriptor2 == null) {
            $$$reportNull$$$0(54);
        }
        if (!Visibilities.isPrivate(memberDescriptor2.getVisibility()) && Visibilities.isVisibleIgnoringReceiver(memberDescriptor2, memberDescriptor)) {
            return true;
        }
        return false;
    }

    public static boolean allHasSameContainingDeclaration(Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(59);
        }
        if (collection.size() < 2) {
            return true;
        }
        final DeclarationDescriptor containingDeclaration = collection.iterator().next().getContainingDeclaration();
        return CollectionsKt___CollectionsKt.all(collection, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                boolean z;
                if (callableMemberDescriptor.getContainingDeclaration() == DeclarationDescriptor.this) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public static List<KotlinType> compiledValueParameters(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        for (ValueParameterDescriptor valueParameterDescriptor : callableDescriptor.getValueParameters()) {
            arrayList.add(valueParameterDescriptor.getType());
        }
        return arrayList;
    }

    public static OverridingUtil createWithEqualityAxioms(KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(0);
        }
        return new OverridingUtil(typeConstructorEquality, KotlinTypeRefiner.Default.INSTANCE);
    }

    public static OverridingUtil createWithTypeRefiner(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(1);
        }
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, kotlinTypeRefiner);
    }

    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(Set<D> set) {
        boolean z;
        if (set == null) {
            $$$reportNull$$$0(4);
        }
        if (!set.isEmpty() && DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule(set.iterator().next()))) {
            z = true;
        } else {
            z = false;
        }
        return filterOverrides(set, z, null, new Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;>; */
            @Override // kotlin.jvm.functions.Function2
            public Pair invoke(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
                return new Pair(callableDescriptor, callableDescriptor2);
            }
        });
    }

    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(11);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        collectOverriddenDeclarations(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean areTypeParametersEquivalent(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, KotlinTypeChecker kotlinTypeChecker) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(45);
        }
        if (typeParameterDescriptor2 == null) {
            $$$reportNull$$$0(46);
        }
        if (kotlinTypeChecker == null) {
            $$$reportNull$$$0(47);
        }
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        ArrayList arrayList = new ArrayList(typeParameterDescriptor2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (KotlinType kotlinType : upperBounds) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (areTypesEquivalent(kotlinType, (KotlinType) listIterator.next(), kotlinTypeChecker)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    public static void createAndBindFakeOverride(Collection<CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        Visibility visibility;
        if (collection == null) {
            $$$reportNull$$$0(80);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(81);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(82);
        }
        Collection<CallableMemberDescriptor> filterVisibleFakeOverrides = filterVisibleFakeOverrides(classDescriptor, collection);
        boolean isEmpty = filterVisibleFakeOverrides.isEmpty();
        if (!isEmpty) {
            collection = filterVisibleFakeOverrides;
        }
        Modality determineModalityForFakeOverride = determineModalityForFakeOverride(collection, classDescriptor);
        if (isEmpty) {
            visibility = Visibilities.INVISIBLE_FAKE;
        } else {
            visibility = Visibilities.INHERITED;
        }
        CallableMemberDescriptor copy = ((CallableMemberDescriptor) selectMostSpecificMember(collection, new Function1<CallableMemberDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor;
            }
        })).copy(classDescriptor, determineModalityForFakeOverride, visibility, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        overridingStrategy.setOverriddenDescriptors(copy, collection);
        overridingStrategy.addFakeOverride(copy);
    }

    public static void createAndBindFakeOverrides(ClassDescriptor classDescriptor, Collection<CallableMemberDescriptor> collection, OverridingStrategy overridingStrategy) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(60);
        }
        if (collection == null) {
            $$$reportNull$$$0(61);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(62);
        }
        if (allHasSameContainingDeclaration(collection)) {
            for (CallableMemberDescriptor callableMemberDescriptor : collection) {
                createAndBindFakeOverride(Collections.singleton(callableMemberDescriptor), classDescriptor, overridingStrategy);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            createAndBindFakeOverride(extractMembersOverridableInBothWays(VisibilityUtilKt.findMemberWithMaxVisibility(linkedList), linkedList, overridingStrategy), classDescriptor, overridingStrategy);
        }
    }

    public static <D extends CallableDescriptor> boolean overrides(D d, D d2, boolean z) {
        if (d == null) {
            $$$reportNull$$$0(9);
        }
        if (d2 == null) {
            $$$reportNull$$$0(10);
        }
        if (!d.equals(d2) && DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(d.getOriginal(), d2.getOriginal(), z)) {
            return true;
        }
        CallableDescriptor original = d2.getOriginal();
        for (CallableDescriptor callableDescriptor : DescriptorUtils.getAllOverriddenDescriptors(d)) {
            if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(original, callableDescriptor, z)) {
                return true;
            }
        }
        return false;
    }

    private boolean areTypesEquivalent(KotlinType kotlinType, KotlinType kotlinType2, KotlinTypeChecker kotlinTypeChecker) {
        boolean z;
        if (kotlinType == null) {
            $$$reportNull$$$0(42);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(43);
        }
        if (kotlinTypeChecker == null) {
            $$$reportNull$$$0(44);
        }
        if (KotlinTypeKt.isError(kotlinType) && KotlinTypeKt.isError(kotlinType2)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return kotlinTypeChecker.equalTypes(this.kotlinTypeRefiner.refineType(kotlinType), this.kotlinTypeRefiner.refineType(kotlinType2));
    }

    public static Modality getMinimalModality(Collection<CallableMemberDescriptor> collection, boolean z, Modality modality) {
        Modality modality2;
        if (collection == null) {
            $$$reportNull$$$0(88);
        }
        if (modality == null) {
            $$$reportNull$$$0(89);
        }
        Modality modality3 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            if (z && callableMemberDescriptor.getModality() == Modality.ABSTRACT) {
                modality2 = modality;
            } else {
                modality2 = callableMemberDescriptor.getModality();
            }
            if (modality2.compareTo(modality3) < 0) {
                modality3 = modality2;
            }
        }
        if (modality3 == null) {
            $$$reportNull$$$0(90);
        }
        return modality3;
    }

    public static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z;
        boolean z2 = true;
        if (callableDescriptor.getExtensionReceiverParameter() == null) {
            z = true;
        } else {
            z = false;
        }
        if (callableDescriptor2.getExtensionReceiverParameter() != null) {
            z2 = false;
        }
        if (z != z2) {
            return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
        }
        if (callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size()) {
            return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
        }
        return null;
    }

    public static void collectOverriddenDeclarations(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(13);
        }
        if (set == null) {
            $$$reportNull$$$0(14);
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
                collectOverriddenDeclarations(callableMemberDescriptor2, set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    private KotlinTypeChecker createTypeChecker(List<TypeParameterDescriptor> list, List<TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$0(38);
        }
        if (list2 == null) {
            $$$reportNull$$$0(39);
        }
        if (list.isEmpty()) {
            KotlinTypeChecker withAxioms = KotlinTypeCheckerImpl.withAxioms(this.equalityAxioms);
            if (withAxioms == null) {
                $$$reportNull$$$0(40);
            }
            return withAxioms;
        }
        final HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
        }
        KotlinTypeChecker withAxioms2 = KotlinTypeCheckerImpl.withAxioms(new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.3
            public static /* synthetic */ void $$$reportNull$$$0(int i2) {
                Object[] objArr = new Object[3];
                if (i2 != 1) {
                    objArr[0] = "a";
                } else {
                    objArr[0] = "b";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$3";
                objArr[2] = "equals";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
            public boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                }
                if (typeConstructor2 == null) {
                    $$$reportNull$$$0(1);
                }
                if (OverridingUtil.this.equalityAxioms.equals(typeConstructor, typeConstructor2)) {
                    return true;
                }
                TypeConstructor typeConstructor3 = (TypeConstructor) hashMap.get(typeConstructor);
                TypeConstructor typeConstructor4 = (TypeConstructor) hashMap.get(typeConstructor2);
                if ((typeConstructor3 == null || !typeConstructor3.equals(typeConstructor2)) && (typeConstructor4 == null || !typeConstructor4.equals(typeConstructor))) {
                    return false;
                }
                return true;
            }
        });
        if (withAxioms2 == null) {
            $$$reportNull$$$0(41);
        }
        return withAxioms2;
    }

    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z;
        if (callableDescriptor == null) {
            $$$reportNull$$$0(36);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(37);
        }
        boolean z2 = callableDescriptor instanceof FunctionDescriptor;
        if ((z2 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
            return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        }
        if (!z2 && !z) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        } else if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return OverrideCompatibilityInfo.incompatible("Name mismatch");
        } else {
            OverrideCompatibilityInfo checkReceiverAndParameterCount = checkReceiverAndParameterCount(callableDescriptor, callableDescriptor2);
            if (checkReceiverAndParameterCount != null) {
                return checkReceiverAndParameterCount;
            }
            return null;
        }
    }

    public static Visibility computeVisibilityToInherit(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(103);
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Visibility findMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (findMaxVisibility == null) {
            return null;
        }
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
                if (callableMemberDescriptor2.getModality() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(findMaxVisibility)) {
                    return null;
                }
            }
            return findMaxVisibility;
        }
        return findMaxVisibility.normalize();
    }

    public static Modality determineModalityForFakeOverride(Collection<CallableMemberDescriptor> collection, ClassDescriptor classDescriptor) {
        Modality modality;
        if (collection == null) {
            $$$reportNull$$$0(83);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(84);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i = AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[callableMemberDescriptor.getModality().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            z3 = true;
                        }
                    } else {
                        z2 = true;
                    }
                } else {
                    throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
                }
            } else {
                Modality modality2 = Modality.FINAL;
                if (modality2 == null) {
                    $$$reportNull$$$0(85);
                }
                return modality2;
            }
        }
        if (classDescriptor.isExpect() && classDescriptor.getModality() != Modality.ABSTRACT && classDescriptor.getModality() != Modality.SEALED) {
            z = true;
        }
        if (z2 && !z3) {
            Modality modality3 = Modality.OPEN;
            if (modality3 == null) {
                $$$reportNull$$$0(86);
            }
            return modality3;
        } else if (!z2 && z3) {
            if (z) {
                modality = classDescriptor.getModality();
            } else {
                modality = Modality.ABSTRACT;
            }
            if (modality == null) {
                $$$reportNull$$$0(87);
            }
            return modality;
        } else {
            HashSet hashSet = new HashSet();
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                hashSet.addAll(getOverriddenDeclarations(callableMemberDescriptor2));
            }
            return getMinimalModality(filterOutOverridden(hashSet), z, classDescriptor.getModality());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.jvm.functions.Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <H> H selectMostSpecificMember(Collection<H> collection, Function1<H, CallableDescriptor> function1) {
        if (collection == null) {
            $$$reportNull$$$0(73);
        }
        if (function1 == 0) {
            $$$reportNull$$$0(74);
        }
        if (collection.size() == 1) {
            H h = (H) CollectionsKt___CollectionsKt.first(collection);
            if (h == null) {
                $$$reportNull$$$0(75);
            }
            return h;
        }
        ArrayList arrayList = new ArrayList(2);
        List map = CollectionsKt___CollectionsKt.map(collection, function1);
        H h2 = (H) CollectionsKt___CollectionsKt.first(collection);
        CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(h2);
        for (H h3 : collection) {
            CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.invoke(h3);
            if (isMoreSpecificThenAllOf(callableDescriptor2, map)) {
                arrayList.add(h3);
            }
            if (isMoreSpecific(callableDescriptor2, callableDescriptor) && !isMoreSpecific(callableDescriptor, callableDescriptor2)) {
                h2 = h3;
            }
        }
        if (arrayList.isEmpty()) {
            if (h2 == null) {
                $$$reportNull$$$0(76);
            }
            return h2;
        } else if (arrayList.size() == 1) {
            H h4 = (H) CollectionsKt___CollectionsKt.first((Iterable<? extends Object>) arrayList);
            if (h4 == null) {
                $$$reportNull$$$0(77);
            }
            return h4;
        } else {
            H h5 = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!FlexibleTypesKt.isFlexible(((CallableDescriptor) function1.invoke(next)).getReturnType())) {
                    h5 = next;
                    break;
                }
            }
            if (h5 != null) {
                if (h5 == null) {
                    $$$reportNull$$$0(78);
                }
                return h5;
            }
            H h6 = (H) CollectionsKt___CollectionsKt.first((Iterable<? extends Object>) arrayList);
            if (h6 == null) {
                $$$reportNull$$$0(79);
            }
            return h6;
        }
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(55);
        }
        if (collection == null) {
            $$$reportNull$$$0(56);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(57);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(58);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        SmartSet create = SmartSet.create();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).getResult();
            boolean isVisibleForOverride = isVisibleForOverride(callableMemberDescriptor, callableMemberDescriptor2);
            int i = AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[result.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    if (isVisibleForOverride) {
                        overridingStrategy.overrideConflict(callableMemberDescriptor2, callableMemberDescriptor);
                    }
                    arrayList.add(callableMemberDescriptor2);
                }
            } else {
                if (isVisibleForOverride) {
                    create.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        overridingStrategy.setOverriddenDescriptors(callableMemberDescriptor, create);
        return arrayList;
    }

    public static <D> Set<D> filterOverrides(Set<D> set, boolean z, Function0<?> function0, Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            $$$reportNull$$$0(5);
        }
        if (function2 == null) {
            $$$reportNull$$$0(6);
        }
        if (set.size() <= 1) {
            if (set == null) {
                $$$reportNull$$$0(7);
            }
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair<CallableDescriptor, CallableDescriptor> invoke = function2.invoke(obj, (Object) it.next());
                    CallableDescriptor component1 = invoke.component1();
                    CallableDescriptor component2 = invoke.component2();
                    if (overrides(component1, component2, z)) {
                        it.remove();
                    } else if (overrides(component2, component1, z)) {
                        break;
                    }
                } else {
                    linkedHashSet.add(obj);
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H h, Collection<H> collection, Function1<H, CallableDescriptor> function1, Function1<H, Unit> function12) {
        if (h == null) {
            $$$reportNull$$$0(94);
        }
        if (collection == null) {
            $$$reportNull$$$0(95);
        }
        if (function1 == null) {
            $$$reportNull$$$0(96);
        }
        if (function12 == null) {
            $$$reportNull$$$0(97);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        CallableDescriptor invoke = function1.invoke(h);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            CallableDescriptor invoke2 = function1.invoke(next);
            if (h == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result bothWaysOverridability = getBothWaysOverridability(invoke, invoke2);
                if (bothWaysOverridability == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (bothWaysOverridability == OverrideCompatibilityInfo.Result.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(final CallableMemberDescriptor callableMemberDescriptor, Queue<CallableMemberDescriptor> queue, final OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(99);
        }
        if (queue == null) {
            $$$reportNull$$$0(100);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(101);
        }
        return extractMembersOverridableInBothWays(callableMemberDescriptor, queue, new Function1<CallableMemberDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public CallableDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                return callableMemberDescriptor2;
            }
        }, new Function1<CallableMemberDescriptor, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                OverridingStrategy.this.inheritanceConflict(callableMemberDescriptor, callableMemberDescriptor2);
                return Unit.INSTANCE;
            }
        });
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(16);
        }
        OverrideCompatibilityInfo isOverridableBy = isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (isOverridableBy == null) {
            $$$reportNull$$$0(17);
        }
        return isOverridableBy;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Visibility findMaxVisibility(Collection<? extends CallableMemberDescriptor> collection) {
        Visibility visibility;
        if (collection == null) {
            $$$reportNull$$$0(104);
        }
        if (collection.isEmpty()) {
            return Visibilities.DEFAULT_VISIBILITY;
        }
        loop0: while (true) {
            visibility = null;
            for (CallableMemberDescriptor callableMemberDescriptor : collection) {
                Visibility visibility2 = callableMemberDescriptor.getVisibility();
                if (visibility != null) {
                    Integer compare = Visibilities.compare(visibility2, visibility);
                    if (compare == null) {
                        break;
                    } else if (compare.intValue() > 0) {
                    }
                }
                visibility = visibility2;
            }
        }
        if (visibility == null) {
            return null;
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            Integer compare2 = Visibilities.compare(visibility, callableMemberDescriptor2.getVisibility());
            if (compare2 == null || compare2.intValue() < 0) {
                return null;
            }
            while (r5.hasNext()) {
            }
        }
        return visibility;
    }

    public static boolean isMoreSpecific(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(63);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(64);
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        KotlinType returnType2 = callableDescriptor2.getReturnType();
        if (!isVisibilityMoreSpecific(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        if (callableDescriptor instanceof FunctionDescriptor) {
            return isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2);
        }
        if (callableDescriptor instanceof PropertyDescriptor) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
            PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
            if (!isAccessorMoreSpecific(propertyDescriptor.getSetter(), propertyDescriptor2.getSetter())) {
                return false;
            }
            if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
                return DEFAULT.createTypeChecker(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters()).equalTypes(returnType, returnType2);
            }
            if ((!propertyDescriptor.isVar() && propertyDescriptor2.isVar()) || !isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2)) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Unexpected callable: " + callableDescriptor.getClass());
    }

    public static void resolveUnknownVisibilityForMember(CallableMemberDescriptor callableMemberDescriptor, Function1<CallableMemberDescriptor, Unit> function1) {
        Visibility visibility;
        Function1<CallableMemberDescriptor, Unit> function12;
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(102);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == Visibilities.INHERITED) {
                resolveUnknownVisibilityForMember(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() != Visibilities.INHERITED) {
            return;
        }
        Visibility computeVisibilityToInherit = computeVisibilityToInherit(callableMemberDescriptor);
        if (computeVisibilityToInherit == null) {
            if (function1 != null) {
                function1.invoke(callableMemberDescriptor);
            }
            visibility = Visibilities.PUBLIC;
        } else {
            visibility = computeVisibilityToInherit;
        }
        if (callableMemberDescriptor instanceof PropertyDescriptorImpl) {
            ((PropertyDescriptorImpl) callableMemberDescriptor).setVisibility(visibility);
            for (PropertyAccessorDescriptor propertyAccessorDescriptor : ((PropertyDescriptor) callableMemberDescriptor).getAccessors()) {
                if (computeVisibilityToInherit == null) {
                    function12 = null;
                } else {
                    function12 = function1;
                }
                resolveUnknownVisibilityForMember(propertyAccessorDescriptor, function12);
            }
        } else if (callableMemberDescriptor instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl) callableMemberDescriptor).setVisibility(visibility);
        } else {
            PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl = (PropertyAccessorDescriptorImpl) callableMemberDescriptor;
            propertyAccessorDescriptorImpl.setVisibility(visibility);
            if (visibility != propertyAccessorDescriptorImpl.getCorrespondingProperty().getVisibility()) {
                propertyAccessorDescriptorImpl.setDefault(false);
            }
        }
    }

    public static boolean isReturnTypeMoreSpecific(CallableDescriptor callableDescriptor, KotlinType kotlinType, CallableDescriptor callableDescriptor2, KotlinType kotlinType2) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(69);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(70);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(71);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(72);
        }
        return DEFAULT.createTypeChecker(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters()).isSubtypeOf(kotlinType, kotlinType2);
    }

    public void generateOverridesInFunctionGroup(Name name, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, ClassDescriptor classDescriptor, OverridingStrategy overridingStrategy) {
        if (name == null) {
            $$$reportNull$$$0(48);
        }
        if (collection == null) {
            $$$reportNull$$$0(49);
        }
        if (collection2 == null) {
            $$$reportNull$$$0(50);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(51);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(52);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
            linkedHashSet.removeAll(extractAndBindOverridesForMember(callableMemberDescriptor, collection, classDescriptor, overridingStrategy));
        }
        createAndBindFakeOverrides(classDescriptor, linkedHashSet, overridingStrategy);
    }

    public OverrideCompatibilityInfo isOverridableBy(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor, boolean z) {
        boolean z2;
        if (callableDescriptor == null) {
            $$$reportNull$$$0(18);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(19);
        }
        OverrideCompatibilityInfo isOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z);
        if (isOverridableByWithoutExternalConditions.getResult() == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
            z2 = true;
        } else {
            z2 = false;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition : EXTERNAL_CONDITIONS) {
            if (externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z2 || externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i = AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("External condition");
                            if (incompatible == null) {
                                $$$reportNull$$$0(21);
                            }
                            return incompatible;
                        }
                    } else {
                        OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("External condition failed");
                        if (conflict == null) {
                            $$$reportNull$$$0(20);
                        }
                        return conflict;
                    }
                } else {
                    z2 = true;
                }
            }
        }
        if (!z2) {
            if (isOverridableByWithoutExternalConditions == null) {
                $$$reportNull$$$0(22);
            }
            return isOverridableByWithoutExternalConditions;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition2 : EXTERNAL_CONDITIONS) {
            if (externalOverridabilityCondition2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i2 = AnonymousClass9.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("External condition");
                            if (incompatible2 == null) {
                                $$$reportNull$$$0(24);
                            }
                            return incompatible2;
                        }
                    } else {
                        OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("External condition failed");
                        if (conflict2 == null) {
                            $$$reportNull$$$0(23);
                        }
                        return conflict2;
                    }
                } else {
                    throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                }
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(25);
        }
        return success;
    }

    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(26);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(27);
        }
        OverrideCompatibilityInfo basicOverridabilityProblem = getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if (basicOverridabilityProblem != null) {
            if (basicOverridabilityProblem == null) {
                $$$reportNull$$$0(28);
            }
            return basicOverridabilityProblem;
        }
        List<KotlinType> compiledValueParameters = compiledValueParameters(callableDescriptor);
        List<KotlinType> compiledValueParameters2 = compiledValueParameters(callableDescriptor2);
        List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        int i = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i < compiledValueParameters.size()) {
                if (!KotlinTypeChecker.DEFAULT.equalTypes(compiledValueParameters.get(i), compiledValueParameters2.get(i))) {
                    OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
                    if (incompatible == null) {
                        $$$reportNull$$$0(29);
                    }
                    return incompatible;
                }
                i++;
            }
            OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
            if (conflict == null) {
                $$$reportNull$$$0(30);
            }
            return conflict;
        }
        KotlinTypeChecker createTypeChecker = createTypeChecker(typeParameters, typeParameters2);
        for (int i2 = 0; i2 < typeParameters.size(); i2++) {
            if (!areTypeParametersEquivalent(typeParameters.get(i2), typeParameters2.get(i2), createTypeChecker)) {
                OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
                if (incompatible2 == null) {
                    $$$reportNull$$$0(31);
                }
                return incompatible2;
            }
        }
        for (int i3 = 0; i3 < compiledValueParameters.size(); i3++) {
            if (!areTypesEquivalent(compiledValueParameters.get(i3), compiledValueParameters2.get(i3), createTypeChecker)) {
                OverrideCompatibilityInfo incompatible3 = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
                if (incompatible3 == null) {
                    $$$reportNull$$$0(32);
                }
                return incompatible3;
            }
        }
        if ((callableDescriptor instanceof FunctionDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && ((FunctionDescriptor) callableDescriptor).isSuspend() != ((FunctionDescriptor) callableDescriptor2).isSuspend()) {
            OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
            if (conflict2 == null) {
                $$$reportNull$$$0(33);
            }
            return conflict2;
        }
        if (z) {
            KotlinType returnType = callableDescriptor.getReturnType();
            KotlinType returnType2 = callableDescriptor2.getReturnType();
            if (returnType != null && returnType2 != null) {
                if (KotlinTypeKt.isError(returnType2) && KotlinTypeKt.isError(returnType)) {
                    i = 1;
                }
                if (i == 0 && !createTypeChecker.isSubtypeOf(this.kotlinTypeRefiner.refineType(returnType2), this.kotlinTypeRefiner.refineType(returnType))) {
                    OverrideCompatibilityInfo conflict3 = OverrideCompatibilityInfo.conflict("Return type mismatch");
                    if (conflict3 == null) {
                        $$$reportNull$$$0(34);
                    }
                    return conflict3;
                }
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(35);
        }
        return success;
    }
}
