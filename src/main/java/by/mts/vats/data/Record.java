package by.mts.vats.data;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Record {
    int id;
    LocalDateTime callDate;
    int callDuration;
    CallerPart callerPart;
    CalleePart calleePart;
    String recordName;
    boolean isOutgoing;

    @Value
    private class CalleePart {
        String name;
        String fullNumber;
        boolean isExternalPbxClient;
    }

    @Value
    private class CallerPart {
        String fullNumber;
        boolean isExternalPbxClient;
        String name;
    }
}