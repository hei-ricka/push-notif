import { Text, View } from "react-native";
import messaging from "@react-native-firebase/messaging";
import { useEffect } from "react";

async function requestUserPermission() {
  const authStatus = await messaging().requestPermission();
  const enabled =
    authStatus === messaging.AuthorizationStatus.AUTHORIZED ||
    authStatus === messaging.AuthorizationStatus.PROVISIONAL;

  if (enabled) {
    console.log('Authorization status:', authStatus);
  }
}

export function App() {
  useEffect(() => {
    requestUserPermission();
    messaging().getToken().then(token => console.log(token));
  });

  return (
    <View>
      <Text style={{ color: "black", textAlign: "center", marginTop: 50 }}>Hello World</Text>
    </View>
  )
}
